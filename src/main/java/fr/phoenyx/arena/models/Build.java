package fr.phoenyx.arena.models;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_AGILITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_ITEM;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_OWNER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_INTELLIGENCE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_SPECIALIZATION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_STRENGTH;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_TYPE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_VITALITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BUILDS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BUILDS_ITEMS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BUILDS_TYPES;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.Specialization;
import fr.phoenyx.arena.enums.Type;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_BUILDS)
public class Build extends GenericEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_OWNER)
    private Player owner;

    @Column(name = COLUMN_VITALITY, nullable = false)
    private int vitality;

    @Column(name = COLUMN_STRENGTH, nullable = false)
    private int strength;

    @Column(name = COLUMN_INTELLIGENCE, nullable = false)
    private int intelligence;

    @Column(name = COLUMN_AGILITY, nullable = false)
    private int agility;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "build")
    private Set<ActiveSkill> activeSkills = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "build")
    private Set<PassiveSkill> passiveSkills = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_BUILDS_ITEMS,
        joinColumns = @JoinColumn(name = COLUMN_ID_BUILD, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_ITEM, referencedColumnName = COLUMN_ID)
    )
    private List<Item> stuff = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_SPECIALIZATION)
    private Specialization specialization;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Type.class)
    @JoinTable(name = TABLE_BUILDS_TYPES, joinColumns = @JoinColumn(name = COLUMN_ID_BUILD))
    @Column(name = COLUMN_TYPE, nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Type> types = new HashSet<>();
}

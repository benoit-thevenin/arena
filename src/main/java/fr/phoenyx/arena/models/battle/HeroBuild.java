package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_AGILITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_HERO_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_ITEM;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_INTELLIGENCE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_STRENGTH;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_VITALITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_HERO_BUILDS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_HERO_BUILDS_ITEMS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_HERO_BUILDS)
public class HeroBuild extends GenericEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "heroBuild")
    private List<Hero> heroes = new ArrayList<>();

    @Column(name = COLUMN_VITALITY, nullable = false)
    private int vitality;

    @Column(name = COLUMN_STRENGTH, nullable = false)
    private int strength;

    @Column(name = COLUMN_INTELLIGENCE, nullable = false)
    private int intelligence;

    @Column(name = COLUMN_AGILITY, nullable = false)
    private int agility;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = COLUMN_ID_HERO_BUILD)
    private List<ActiveSkill> activeSkills = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = COLUMN_ID_HERO_BUILD)
    private List<PassiveSkill> passiveSkills = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_HERO_BUILDS_ITEMS,
        joinColumns = @JoinColumn(name = COLUMN_ID_HERO_BUILD, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_ITEM, referencedColumnName = COLUMN_ID)
    )
    private List<Item> stuff = new ArrayList<>();
}

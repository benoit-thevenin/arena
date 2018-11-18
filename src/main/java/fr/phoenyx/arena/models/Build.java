package fr.phoenyx.arena.models;

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
@Table(name = "BUILD")
public class Build extends GenericEntity {

    @Column(name = "VITALITY")
    private int vitality;

    @Column(name = "STRENGTH")
    private int strength;

    @Column(name = "INTELLIGENCE")
    private int intelligence;

    @Column(name = "AGILITY")
    private int agility;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BUILD")
    private List<ActiveSkill> activeSkills = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BUILD")
    private List<PassiveSkill> passiveSkills = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BUILD_ITEM",
        joinColumns = @JoinColumn(name = "ID_BUILD", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_ITEM", referencedColumnName = "ID")
    )
    private List<Item> stuff = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Type.class)
    @JoinTable(name = "BUILD_TYPE", joinColumns = @JoinColumn(name = "ID_BUILD"))
    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Type> types = new HashSet<>();
}

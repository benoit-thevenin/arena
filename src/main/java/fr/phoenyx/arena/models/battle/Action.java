package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ACTION_ORDER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_ACTION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_CASTER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_HERO;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_SKILL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_ACTIONS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_ACTIONS_HEROES;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_ACTIONS)
public class Action extends GenericEntity implements Comparable<Action> {

    @Column(name = COLUMN_ACTION_ORDER, nullable = false)
    private int actionOrder;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_CASTER)
    private Hero caster;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_SKILL)
    private ActiveSkill skill;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_ACTIONS_HEROES,
        joinColumns = @JoinColumn(name = COLUMN_ID_ACTION, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_HERO, referencedColumnName = COLUMN_ID)
    )
    private Set<Hero> targets = new HashSet<>();

    @Column(name = "RAND", nullable = false)
    private double rand;

    @Override
    public int compareTo(Action other) {
        return Integer.compare(actionOrder, other.getActionOrder());
    }
}

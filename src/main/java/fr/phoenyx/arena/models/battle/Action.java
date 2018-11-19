package fr.phoenyx.arena.models.battle;

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
@Table(name = "ACTIONS")
public class Action extends GenericEntity implements Comparable<Action> {

    @Column(name = "ACTION_ORDER")
    private int actionOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CASTER")
    private Hero caster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SKILL")
    private ActiveSkill skill;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ACTION_HERO",
        joinColumns = @JoinColumn(name = "ID_ACTION", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_HERO", referencedColumnName = "ID")
    )
    private Set<Hero> targets = new HashSet<>();

    @Column(name = "RAND")
    private double rand;

    @Override
    public int compareTo(Action other) {
        return Integer.compare(actionOrder, other.getActionOrder());
    }
}

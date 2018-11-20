package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BATTLE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_ROUND;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ROUND_NUMBER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_ROUNDS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_ROUNDS)
public class Round extends GenericEntity implements Comparable<Round> {

    @Column(name = COLUMN_ROUND_NUMBER, nullable = false)
    private int roundNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = COLUMN_ID_ROUND)
    private Set<Action> actionsPerformed = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = COLUMN_ID_BATTLE)
    private Set<Hero> heroes = new HashSet<>();

    @Override
    public int compareTo(Round other) {
        return Integer.compare(roundNumber, other.getRoundNumber());
    }
}

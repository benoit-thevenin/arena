package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BATTLE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_TEAM1;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_TEAM2;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BATTLES;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.Team;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_BATTLES)
public class Battle extends GenericEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_TEAM1)
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_TEAM2)
    private Team team2;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = COLUMN_ID_BATTLE)
    private Set<Round> rounds = new HashSet<>();
}

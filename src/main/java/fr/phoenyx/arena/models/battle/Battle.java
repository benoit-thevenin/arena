package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BATTLE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BATTLES;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BATTLES_PLAYERS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_BATTLES)
public class Battle extends GenericEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_BATTLES_PLAYERS,
        joinColumns = @JoinColumn(name = COLUMN_ID_BATTLE, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_PLAYER, referencedColumnName = COLUMN_ID)
    )
    private Set<Player> players = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = COLUMN_ID_BATTLE)
    private Set<Round> rounds = new HashSet<>();
}

package fr.phoenyx.arena.models.battle;

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
@Table(name = "BATTLE")
public class Battle extends GenericEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BATTLE_PLAYER",
        joinColumns = @JoinColumn(name = "ID_BATTLE", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_PLAYER", referencedColumnName = "ID")
    )
    private Set<Player> players = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BATTLE")
    private Set<Hero> heroes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BATTLE")
    private Set<Round> rounds = new HashSet<>();
}

package fr.phoenyx.arena.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.models.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAYER")
public class Player extends GenericEntity {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "HASH_PASSWORD")
    private String hashPassword;

    @Column(name = "SALT")
    private String salt;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LAST_CONNECTION")
    private LocalDateTime lastConnection;

    @Column(name = "GOLD")
    private int gold;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "EXPERIENCE")
    private long experience;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OWNER")
    private List<Item> inventory = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_OWNER")
    private List<Build> builds = new ArrayList<>();

    //FIXME manage the GuildMember link
    @ManyToOne(fetch = FetchType.LAZY)
    private Guild guild;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PLAYER_FRIEND",
        joinColumns = @JoinColumn(name = "ID_PLAYER1", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_PLAYER2", referencedColumnName = "ID")
    )
    private Set<Player> friends = new HashSet<>();

    public void update(Player modifier) {
        super.update(modifier);
    }
}

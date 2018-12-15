package fr.phoenyx.arena.models;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_EMAIL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_EXPERIENCE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_GOLD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_GUILD_ROLE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_GUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_OWNER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER1;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER2;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LAST_CONNECTION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LEVEL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_USERNAME;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_PLAYERS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_PLAYERS_FRIENDS;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.enums.GuildRole;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.models.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_PLAYERS)
public class Player extends GenericEntity {

    @Column(name = COLUMN_USERNAME, nullable = false, unique = true)
    private String username;

    @Column(name = COLUMN_EMAIL, nullable = false, unique = true)
    private String email;

    @Column(name = COLUMN_LAST_CONNECTION)
    private LocalDateTime lastConnection;

    @Column(name = COLUMN_GOLD, nullable = false)
    private int gold;

    @Column(name = COLUMN_LEVEL, nullable = false)
    private int level;

    @Column(name = COLUMN_EXPERIENCE, nullable = false)
    private long experience;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = COLUMN_ID_OWNER)
    private List<Item> inventory = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
    private Set<Build> builds = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_GUILD)
    private Guild guild;

    @Enumerated
    @Column(name = COLUMN_GUILD_ROLE)
    private GuildRole guildRole;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_PLAYERS_FRIENDS,
        joinColumns = @JoinColumn(name = COLUMN_ID_PLAYER1, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_PLAYER2, referencedColumnName = COLUMN_ID)
    )
    private Set<Player> friends = new HashSet<>();

    public static Player buildNewPlayer(String username, String email) {
        return new PlayerBuilder()
                .username(username)
                .email(email)
                .level(1)
                .dateCreation(LocalDateTime.now()).build();
    }
}

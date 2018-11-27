package fr.phoenyx.arena.models;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_EMAIL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_EXPERIENCE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_GOLD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_HASH_PASS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_GUILD_MEMBER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_OWNER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER1;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER2;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LAST_CONNECTION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LEVEL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_SALT;
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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.models.guild.GuildMember;
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

    @Column(name = COLUMN_HASH_PASS, nullable = false)
    private String hashPassword;

    @Column(name = COLUMN_SALT)
    private String salt;

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
    private List<Build> builds = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = COLUMN_ID_GUILD_MEMBER)
    private GuildMember guildMember;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_PLAYERS_FRIENDS,
        joinColumns = @JoinColumn(name = COLUMN_ID_PLAYER1, referencedColumnName = COLUMN_ID),
        inverseJoinColumns = @JoinColumn(name = COLUMN_ID_PLAYER2, referencedColumnName = COLUMN_ID)
    )
    private Set<Player> friends = new HashSet<>();

    public static Player buildNewPlayer(String username, String hashPassword, String email) {
        Player player = new PlayerBuilder()
                .dateCreation(LocalDateTime.now())
                .username(username)
                .hashPassword(hashPassword)
                .email(email)
                .level(1).build();
        player.setGuildMember(GuildMember.buildNewGuildMember(player));
        return player;
    }
}

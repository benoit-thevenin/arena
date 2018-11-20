package fr.phoenyx.arena.models.guild;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_GUILD_ROLE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_GUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_GUILD_MEMBERS;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.GuildRole;
import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_GUILD_MEMBERS)
public class GuildMember extends GenericEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "guildMember")
    private Player player;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_GUILD_ROLE)
    private GuildRole guildRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_GUILD)
    private Guild guild;

    public static GuildMember buildNewGuildMember(Player player) {
        GuildMember guildMember = new GuildMember();
        guildMember.setDateCreation(LocalDateTime.now());
        guildMember.setPlayer(player);
        return guildMember;
    }
}

package fr.phoenyx.arena.models.guild;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
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
@Table(name = "GUILD_MEMBER")
public class GuildMember extends GenericEntity {

    @OneToOne
    @JoinColumn(name = "ID_PLAYER")
    private Player player;

    @Enumerated(EnumType.STRING)
    private GuildRole guildRole;

    @OneToOne
    @JoinColumn(name = "ID_GUILD")
    private Guild guild;
}

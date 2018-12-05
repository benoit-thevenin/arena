package fr.phoenyx.arena.dtos;

import java.time.LocalDateTime;

import fr.phoenyx.arena.dtos.guild.GuildDTOLight;
import fr.phoenyx.arena.enums.GuildRole;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayerDTOLight extends GenericEntityDTO {

    protected String username;
    protected LocalDateTime lastConnection;
    protected int level;
    protected GuildDTOLight guildLight;
    protected GuildRole guildRole;

    public PlayerDTOLight() {
        super();
    }

    public PlayerDTOLight(Player player) {
        super(player);
        username = player.getUsername();
        lastConnection = player.getLastConnection();
        level = player.getLevel();
        if (player.getGuild() != null) {
            guildLight = new GuildDTOLight(player.getGuild());
        }
        guildRole = player.getGuildRole();
    }
}

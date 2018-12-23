package fr.phoenyx.arena.dtos.social;

import java.time.LocalDateTime;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.social.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayerDTOLight extends GenericEntityDTO {

    protected String username;
    protected LocalDateTime lastConnection;
    protected int level;
    protected GuildDTOLight guildLight;
    protected String guildRole;

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
        if (player.getGuildRole() != null) {
            guildRole = player.getGuildRole().getDescription();
        }
    }
}

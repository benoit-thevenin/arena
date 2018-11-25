package fr.phoenyx.arena.dtos;

import java.time.LocalDateTime;
import java.util.Optional;

import fr.phoenyx.arena.dtos.guild.GuildMemberDTO;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayerDTOLight extends GenericEntityDTO {

    protected String username;
    protected LocalDateTime lastConnection;
    protected int level;
    protected GuildMemberDTO guildMember;

    public PlayerDTOLight() {
        super();
    }

    public PlayerDTOLight(Player player) {
        this();
        username = player.getUsername();
        lastConnection = player.getLastConnection();
        level = player.getLevel();
        guildMember = new GuildMemberDTO(player.getGuildMember(), Optional.of(this));
    }
}

package fr.phoenyx.arena.dtos.guild;

import java.util.Optional;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.PlayerDTOLight;
import fr.phoenyx.arena.models.guild.GuildMember;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuildMemberDTO extends GenericEntityDTO {

    private PlayerDTOLight player;
    private String guildRole;
    private GuildDTO guild;

    public GuildMemberDTO() {
        super();
    }

    public GuildMemberDTO(GuildMember guildMember, Optional<PlayerDTOLight> player) {
        super(guildMember);
        if (player.isPresent()) {
            this.player = player.get();
        } else {
            this.player = new PlayerDTOLight(guildMember.getPlayer());
        }
        guildRole = guildMember.getGuildRole().getDescription();
        if (guildMember.getGuild() != null) {
            guild = new GuildDTO(guildMember.getGuild());
        }
    }
}

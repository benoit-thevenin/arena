package fr.phoenyx.arena.dtos.guild;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.phoenyx.arena.models.guild.Guild;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuildDTO extends GuildDTOLight {

    private List<GuildMemberDTO> guildMembers;

    public GuildDTO() {
        super();
    }

    public GuildDTO(Guild guild) {
        super(guild);
        guildMembers = guild.getGuildMembers().stream()
                .map(guildMember -> new GuildMemberDTO(guildMember, Optional.empty()))
                .collect(Collectors.toList());
    }
}

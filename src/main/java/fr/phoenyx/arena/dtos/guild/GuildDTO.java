package fr.phoenyx.arena.dtos.guild;

import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.PlayerDTOLight;
import fr.phoenyx.arena.models.guild.Guild;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuildDTO extends GuildDTOLight {

    private List<PlayerDTOLight> members;

    public GuildDTO() {
        super();
    }

    public GuildDTO(Guild guild) {
        super(guild);
        members = guild.getMembers().stream()
                .map(PlayerDTOLight::new)
                .collect(Collectors.toList());
    }
}

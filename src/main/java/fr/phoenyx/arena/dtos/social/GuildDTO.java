package fr.phoenyx.arena.dtos.social;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.models.social.Guild;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuildDTO extends GuildDTOLight {

    private Set<PlayerDTOLight> members = new HashSet<>();
    private Set<ApplicantDTO> applicants = new HashSet<>();

    public GuildDTO() {
        super();
    }

    public GuildDTO(Guild guild) {
        super(guild);
        members = guild.getMembers().stream()
                .map(PlayerDTOLight::new)
                .collect(Collectors.toSet());
        applicants = guild.getApplicants().stream()
                .map(ApplicantDTO::new)
                .collect(Collectors.toSet());
    }
}

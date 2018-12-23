package fr.phoenyx.arena.dtos.social;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.social.Team;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamDTO extends GenericEntityDTO {

    private int dimension;
    private PlayerDTOLight leader;
    private Set<ApplicantDTO> members = new HashSet<>();
    private Set<ApplicantDTO> applicants = new HashSet<>();

    public TeamDTO() {
        super();
    }

    public TeamDTO(Team team) {
        super(team);
        dimension = team.getDimension();
        if (team.getLeader() != null) {
            leader = new PlayerDTOLight(team.getLeader());
        }
        members = team.getMembers().stream()
                .map(ApplicantDTO::new)
                .collect(Collectors.toSet());
        applicants = team.getApplicants().stream()
                .map(ApplicantDTO::new)
                .collect(Collectors.toSet());
    }
}

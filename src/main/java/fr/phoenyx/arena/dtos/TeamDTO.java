package fr.phoenyx.arena.dtos;

import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.models.Team;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamDTO extends GenericEntityDTO {

    private int dimension;
    private PlayerDTOLight leader;
    private Set<ApplicantDTO> members;
    private Set<ApplicantDTO> applicants;

    public TeamDTO() {
        super();
    }

    public TeamDTO(Team team) {
        super(team);
        dimension = team.getDimension();
        leader = new PlayerDTOLight(team.getLeader());
        members = team.getMembers().stream()
                .map(member -> new ApplicantDTO(member))
                .collect(Collectors.toSet());
        applicants = team.getApplicants().stream()
                .map(applicant -> new ApplicantDTO(applicant))
                .collect(Collectors.toSet());
    }
}

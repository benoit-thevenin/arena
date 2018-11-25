package fr.phoenyx.arena.dtos;

import fr.phoenyx.arena.models.Applicant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicantDTO extends GenericEntityDTO {

    private PlayerDTOLight player;
    private BuildDTO build;

    public ApplicantDTO() {
        super();
    }

    public ApplicantDTO(Applicant applicant) {
        super(applicant);
        player = new PlayerDTOLight(applicant.getPlayer());
        build = new BuildDTO(applicant.getBuild());
    }
}

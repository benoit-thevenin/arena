package fr.phoenyx.arena.dtos.social;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.dtos.battle.BuildDTO;
import fr.phoenyx.arena.models.social.Applicant;
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
        if (applicant.getPlayer() != null) {
            player = new PlayerDTOLight(applicant.getPlayer());
        }
        if (applicant.getBuild() != null) {
            build = new BuildDTO(applicant.getBuild());
        }
    }
}

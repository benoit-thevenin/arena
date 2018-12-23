package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.ApplicantDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Applicant;

public class ApplicantMapper implements Mapper<Applicant, ApplicantDTO> {

    @Override
    public ApplicantDTO entityToDto(Applicant entity) {
        return new ApplicantDTO(entity);
    }
}

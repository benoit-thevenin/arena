package fr.phoenyx.arena.mappers;

import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.models.Applicant;

public class ApplicantMapper implements Mapper<Applicant, ApplicantDTO> {

    @Override
    public ApplicantDTO entityToDto(Applicant entity) {
        return new ApplicantDTO(entity);
    }

    @Override
    public Applicant dtoToEntity(ApplicantDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

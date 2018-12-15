package fr.phoenyx.arena.services;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.ApplicantMapper;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@Service
public class ApplicantService extends CrudService<Applicant, ApplicantDTO> {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    protected JpaRepository<Applicant, Long> getRepository() {
        return applicantRepository;
    }

    @Override
    protected Mapper<Applicant, ApplicantDTO> getMapper() {
        return new ApplicantMapper();
    }

    @Override
    protected Class<Applicant> getConcernedClass() {
        return Applicant.class;
    }

    @Override
    public ApplicantDTO create(ApplicantDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public ApplicantDTO update(ApplicantDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

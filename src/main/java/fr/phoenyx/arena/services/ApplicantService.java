package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.exceptions.ApplicantException;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<ApplicantDTO> findAll() {
        return applicantRepository.findAll().stream()
                .map(ApplicantDTO::new)
                .collect(Collectors.toList());
    }

    public ApplicantDTO findById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> ApplicantException.entityNotFound(id));
        return new ApplicantDTO(applicant);
    }
}

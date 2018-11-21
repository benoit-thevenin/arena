package fr.phoenyx.arena.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.repositories.ApplicantRepository;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }
}

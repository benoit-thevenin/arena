package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.services.ApplicantService;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/applicants")
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }
}

package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.services.ApplicantService;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/applicants")
    public List<ApplicantDTO> findAll() {
        return applicantService.findAll();
    }

    @GetMapping("/applicants/{id}")
    public ApplicantDTO findById(@PathVariable Long id) {
        return applicantService.findById(id);
    }
}

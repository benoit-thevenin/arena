package fr.phoenyx.arena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ApplicantDTO>> findAll() {
        return new ResponseEntity<>(applicantService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/applicants/{id}")
    public ResponseEntity<ApplicantDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(applicantService.findById(id), HttpStatus.OK);
    }
}

package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_APPLICANTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.ApplicantDTO;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.services.ApplicantService;
import fr.phoenyx.arena.services.CrudService;

@RestController
@RequestMapping(ROOT_APPLICANTS)
public class ApplicantController extends CrudController<Applicant, ApplicantDTO> {

    @Autowired
    private ApplicantService applicantService;

    @Override
    protected CrudService<Applicant, ApplicantDTO> getService() {
        return applicantService;
    }
}

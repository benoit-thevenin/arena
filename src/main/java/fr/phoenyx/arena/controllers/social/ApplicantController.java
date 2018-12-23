package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_APPLICANTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.ApplicantDTO;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.ApplicantService;

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

package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_BUILDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.services.BuildService;
import fr.phoenyx.arena.services.CrudService;

@RestController
@RequestMapping(ROOT_BUILDS)
public class BuildController extends CrudController<Build, BuildDTO> {

    @Autowired
    private BuildService buildService;

    @Override
    protected CrudService<Build, BuildDTO> getService() {
        return buildService;
    }
}

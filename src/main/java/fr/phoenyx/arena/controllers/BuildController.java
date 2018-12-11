package fr.phoenyx.arena.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.services.BuildService;
import fr.phoenyx.arena.services.CrudService;

@RestController
@RequestMapping("/builds")
public class BuildController extends CrudController<Build, Long, BuildDTO> {

    @Autowired
    private BuildService buildService;

    @Override
    protected CrudService<Build, Long, BuildDTO> getService() {
        return buildService;
    }
}

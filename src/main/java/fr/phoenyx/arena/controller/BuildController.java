package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.services.BuildService;

@RestController
public class BuildController {

    @Autowired
    private BuildService buildService;

    @GetMapping("/builds")
    public List<Build> getAllBuilds() {
        return buildService.getAllBuilds();
    }
}

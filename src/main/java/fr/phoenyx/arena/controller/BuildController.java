package fr.phoenyx.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.services.BuildService;

@RestController
public class BuildController {

    @Autowired
    private BuildService buildService;

    @GetMapping("/builds")
    public List<BuildDTO> findAll() {
        return buildService.findAll();
    }

    @GetMapping("/builds/{id}")
    public BuildDTO findById(@PathVariable Long id) {
        return buildService.findById(id);
    }
}

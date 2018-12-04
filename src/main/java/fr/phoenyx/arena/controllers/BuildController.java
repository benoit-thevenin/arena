package fr.phoenyx.arena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BuildDTO>> findAll() {
        return new ResponseEntity<>(buildService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/builds/{id}")
    public ResponseEntity<BuildDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(buildService.findById(id), HttpStatus.OK);
    }
}

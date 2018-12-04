package fr.phoenyx.arena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.TeamDTO;
import fr.phoenyx.arena.services.TeamService;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> findAll() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> findTeamById(@PathVariable Long id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }
}

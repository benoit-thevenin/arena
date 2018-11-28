package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.exceptions.BuildException;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.repositories.BuildRepository;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;

    public List<BuildDTO> findAll() {
        return buildRepository.findAll().stream()
                .map(BuildDTO::new)
                .collect(Collectors.toList());
    }

    public BuildDTO findById(Long id) {
        Build build = buildRepository.findById(id)
                .orElseThrow(() -> BuildException.entityNotFound(id));
        return new BuildDTO(build);
    }
}

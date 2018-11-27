package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.repositories.BuildRepository;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;

    public List<BuildDTO> getAllBuilds() {
        return buildRepository.findAll().stream()
                .map(BuildDTO::new)
                .collect(Collectors.toList());
    }
}

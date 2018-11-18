package fr.phoenyx.arena.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.repositories.BuildRepository;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepository;

    public List<Build> getAllBuilds() {
        return buildRepository.findAll();
    }
}

package fr.phoenyx.arena.services.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.item.Power;

import fr.phoenyx.arena.repositories.item.PowerRepository;

@Service
public class PowerService {

    @Autowired
    private PowerRepository powerRepository;

    public List<Power> getAllPowers() {
        return powerRepository.findAll();
    }
}

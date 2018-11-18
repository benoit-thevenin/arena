package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.repositories.battle.RoundRepository;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }
}

package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.repositories.battle.BattleRepository;

@Service
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public List<Battle> getAllBattles() {
        return battleRepository.findAll();
    }
}

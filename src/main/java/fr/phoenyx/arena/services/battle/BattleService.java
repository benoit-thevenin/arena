package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.repositories.battle.BattleRepository;

@Service
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public List<BattleDTO> getAllBattles() {
        return battleRepository.findAll().stream()
                .map(battle -> new BattleDTO(battle))
                .collect(Collectors.toList());
    }
}

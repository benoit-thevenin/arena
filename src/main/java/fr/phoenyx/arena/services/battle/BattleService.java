package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.exceptions.battle.BattleException;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.repositories.battle.BattleRepository;

@Service
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public List<BattleDTO> findAll() {
        return battleRepository.findAll().stream()
                .map(BattleDTO::new)
                .collect(Collectors.toList());
    }

    public BattleDTO findById(Long id) {
        Battle battle = battleRepository.findById(id)
                .orElseThrow(() -> BattleException.entityNotFound(id));
        return new BattleDTO(battle);
    }
}

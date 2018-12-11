package fr.phoenyx.arena.services.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.BattleDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.BattleMapper;
import fr.phoenyx.arena.models.battle.Battle;
import fr.phoenyx.arena.repositories.battle.BattleRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class BattleService extends CrudService<Battle, Long, BattleDTO> {

    @Autowired
    private BattleRepository battleRepository;

    @Override
    protected JpaRepository<Battle, Long> getRepository() {
        return battleRepository;
    }

    @Override
    protected Mapper<Battle, BattleDTO> getMapper() {
        return new BattleMapper();
    }

    @Override
    protected Class<Battle> getConcernedClass() {
        return Battle.class;
    }
}

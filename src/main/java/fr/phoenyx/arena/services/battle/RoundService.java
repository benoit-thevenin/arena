package fr.phoenyx.arena.services.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.RoundMapper;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.repositories.battle.RoundRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class RoundService extends CrudService<Round, Long, RoundDTO> {

    @Autowired
    private RoundRepository roundRepository;

    @Override
    protected JpaRepository<Round, Long> getRepository() {
        return roundRepository;
    }

    @Override
    protected Mapper<Round, RoundDTO> getMapper() {
        return new RoundMapper();
    }

    @Override
    protected Class<Round> getConcernedClass() {
        return Round.class;
    }
}

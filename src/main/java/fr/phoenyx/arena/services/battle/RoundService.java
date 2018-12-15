package fr.phoenyx.arena.services.battle;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.RoundDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.RoundMapper;
import fr.phoenyx.arena.models.battle.Round;
import fr.phoenyx.arena.repositories.battle.RoundRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class RoundService extends CrudService<Round, RoundDTO> {

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

    @Override
    public RoundDTO create(RoundDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public RoundDTO update(RoundDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

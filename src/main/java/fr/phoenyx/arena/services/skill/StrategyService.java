package fr.phoenyx.arena.services.skill;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.skill.StrategyDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.skill.StrategyMapper;
import fr.phoenyx.arena.models.skill.Strategy;
import fr.phoenyx.arena.repositories.skill.StrategyRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class StrategyService extends CrudService<Strategy, StrategyDTO> {

    @Autowired
    private StrategyRepository strategyRepository;

    @Override
    protected JpaRepository<Strategy, Long> getRepository() {
        return strategyRepository;
    }

    @Override
    protected Mapper<Strategy, StrategyDTO> getMapper() {
        return new StrategyMapper();
    }

    @Override
    protected Class<Strategy> getConcernedClass() {
        return Strategy.class;
    }

    @Override
    public StrategyDTO create(StrategyDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public StrategyDTO update(StrategyDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

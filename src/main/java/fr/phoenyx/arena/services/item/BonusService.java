package fr.phoenyx.arena.services.item;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.item.BonusMapper;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.repositories.item.BonusRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class BonusService extends CrudService<Bonus, BonusDTO> {

    @Autowired
    private BonusRepository bonusRepository;

    @Override
    protected JpaRepository<Bonus, Long> getRepository() {
        return bonusRepository;
    }

    @Override
    protected Mapper<Bonus, BonusDTO> getMapper() {
        return new BonusMapper();
    }

    @Override
    protected Class<Bonus> getConcernedClass() {
        return Bonus.class;
    }

    @Override
    public BonusDTO create(BonusDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public BonusDTO update(BonusDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

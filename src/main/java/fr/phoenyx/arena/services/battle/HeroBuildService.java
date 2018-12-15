package fr.phoenyx.arena.services.battle;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.HeroBuildMapper;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class HeroBuildService extends CrudService<HeroBuild, HeroBuildDTO> {

    @Autowired
    private HeroBuildRepository heroBuildRepository;

    @Override
    protected JpaRepository<HeroBuild, Long> getRepository() {
        return heroBuildRepository;
    }

    @Override
    protected Mapper<HeroBuild, HeroBuildDTO> getMapper() {
        return new HeroBuildMapper();
    }

    @Override
    protected Class<HeroBuild> getConcernedClass() {
        return HeroBuild.class;
    }

    @Override
    public HeroBuildDTO create(HeroBuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public HeroBuildDTO update(HeroBuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

package fr.phoenyx.arena.services.battle;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.ActionMapper;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.repositories.battle.ActionRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class ActionService extends CrudService<Action, ActionDTO> {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    protected JpaRepository<Action, Long> getRepository() {
        return actionRepository;
    }

    @Override
    protected Mapper<Action, ActionDTO> getMapper() {
        return new ActionMapper();
    }

    @Override
    protected Class<Action> getConcernedClass() {
        return Action.class;
    }

    @Override
    public ActionDTO create(ActionDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public ActionDTO update(ActionDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

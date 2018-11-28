package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.exceptions.battle.ActionException;
import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.repositories.battle.ActionRepository;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<ActionDTO> findAll() {
        return actionRepository.findAll().stream()
                .map(ActionDTO::new)
                .collect(Collectors.toList());
    }

    public ActionDTO findById(Long id) {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> ActionException.entityNotFound(id));
        return new ActionDTO(action);
    }
}

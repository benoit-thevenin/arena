package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.ActionDTO;
import fr.phoenyx.arena.repositories.battle.ActionRepository;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<ActionDTO> getAllActions() {
        return actionRepository.findAll().stream()
                .map(ActionDTO::new)
                .collect(Collectors.toList());
    }
}

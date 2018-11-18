package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.battle.Action;
import fr.phoenyx.arena.repositories.battle.ActionRepository;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }
}

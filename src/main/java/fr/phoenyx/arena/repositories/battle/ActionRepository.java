package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Action;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {

    List<Action> findAll();
}

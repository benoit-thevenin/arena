package fr.phoenyx.arena.repositories.battle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

}

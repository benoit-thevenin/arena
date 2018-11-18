package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Battle;

@Repository
public interface BattleRepository extends CrudRepository<Battle, Long> {

    List<Battle> findAll();
}

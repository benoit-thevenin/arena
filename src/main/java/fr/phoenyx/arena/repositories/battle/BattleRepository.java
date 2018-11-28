package fr.phoenyx.arena.repositories.battle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Battle;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {

}

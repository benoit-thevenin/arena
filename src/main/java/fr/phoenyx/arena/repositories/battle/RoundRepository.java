package fr.phoenyx.arena.repositories.battle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}

package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Round;

@Repository
public interface RoundRepository extends CrudRepository<Round, Long> {

    List<Round> findAll();
}

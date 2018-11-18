package fr.phoenyx.arena.repositories.skill;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.skill.Strategy;

@Repository
public interface StrategyRepository extends CrudRepository<Strategy, Long> {

    List<Strategy> findAll();
}

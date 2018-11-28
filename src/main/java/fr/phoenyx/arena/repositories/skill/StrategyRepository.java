package fr.phoenyx.arena.repositories.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.skill.Strategy;

@Repository
public interface StrategyRepository extends JpaRepository<Strategy, Long> {

}

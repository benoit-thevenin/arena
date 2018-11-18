package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Hero;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {

    List<Hero> findAll();
}

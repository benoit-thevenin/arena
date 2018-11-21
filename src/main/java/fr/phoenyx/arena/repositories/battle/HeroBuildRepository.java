package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.HeroBuild;

@Repository
public interface HeroBuildRepository extends CrudRepository<HeroBuild, Long> {

    List<HeroBuild> findAll();
}

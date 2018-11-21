package fr.phoenyx.arena.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findAll();
}

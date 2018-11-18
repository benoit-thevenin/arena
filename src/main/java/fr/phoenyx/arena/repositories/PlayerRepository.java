package fr.phoenyx.arena.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findAll();
}

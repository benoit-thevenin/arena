package fr.phoenyx.arena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}

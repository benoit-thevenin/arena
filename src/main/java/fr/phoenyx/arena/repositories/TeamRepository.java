package fr.phoenyx.arena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}

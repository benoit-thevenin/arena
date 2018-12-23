package fr.phoenyx.arena.repositories.social;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.social.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}

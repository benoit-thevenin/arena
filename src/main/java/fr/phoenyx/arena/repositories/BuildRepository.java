package fr.phoenyx.arena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Build;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {

}

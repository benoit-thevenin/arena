package fr.phoenyx.arena.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Build;

@Repository
public interface BuildRepository extends CrudRepository<Build, Long> {

    List<Build> findAll();
}

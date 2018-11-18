package fr.phoenyx.arena.repositories.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.item.Power;

@Repository
public interface PowerRepository extends CrudRepository<Power, Long> {

    List<Power> findAll();
}

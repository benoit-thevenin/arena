package fr.phoenyx.arena.repositories.battle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.battle.Sheet;

@Repository
public interface SheetRepository extends CrudRepository<Sheet, Long> {

    List<Sheet> findAll();
}

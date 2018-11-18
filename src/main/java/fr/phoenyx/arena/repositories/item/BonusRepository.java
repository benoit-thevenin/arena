package fr.phoenyx.arena.repositories.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.item.Bonus;

@Repository
public interface BonusRepository extends CrudRepository<Bonus, Long> {

    List<Bonus> findAll();
}

package fr.phoenyx.arena.repositories.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.item.Bonus;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {

}

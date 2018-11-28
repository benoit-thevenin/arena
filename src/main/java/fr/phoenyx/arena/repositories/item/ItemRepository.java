package fr.phoenyx.arena.repositories.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.item.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}

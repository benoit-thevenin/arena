package fr.phoenyx.arena.repositories.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.item.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();
}

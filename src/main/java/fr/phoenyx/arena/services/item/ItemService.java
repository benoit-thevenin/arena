package fr.phoenyx.arena.services.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.enums.item.ItemRecipe;
import fr.phoenyx.arena.exceptions.item.ItemException;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.item.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }

    public ItemDTO findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> ItemException.entityNotFound(id));
        return new ItemDTO(item);
    }

    public List<RecipeDTO> getAllRecipes() {
        return Arrays.stream(ItemRecipe.values())
                .map(RecipeDTO::new)
                .collect(Collectors.toList());
    }
}

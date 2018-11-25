package fr.phoenyx.arena.services.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.enums.item.ItemRecipe;
import fr.phoenyx.arena.repositories.item.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO(item))
                .collect(Collectors.toList());
    }

    public List<RecipeDTO> getAllRecipes() {
        return Arrays.stream(ItemRecipe.values())
                .map(itemRecipe -> new RecipeDTO(itemRecipe))
                .collect(Collectors.toList());
    }
}

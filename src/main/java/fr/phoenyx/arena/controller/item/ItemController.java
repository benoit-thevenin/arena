package fr.phoenyx.arena.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.services.item.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<ItemDTO> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/items/{id}")
    public ItemDTO findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/recipes")
    public List<RecipeDTO> getAllRecipes() {
        return itemService.getAllRecipes();
    }
}

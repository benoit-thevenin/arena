package fr.phoenyx.arena.controllers.item;

import static fr.phoenyx.arena.constants.RestConstants.RECIPES;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_ITEMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.item.ItemService;

@RestController
@RequestMapping(ROOT_ITEMS)
public class ItemController extends CrudController<Item, Long, ItemDTO> {

    @Autowired
    private ItemService itemService;

    @Override
    protected CrudService<Item, Long, ItemDTO> getService() {
        return itemService;
    }

    @GetMapping(RECIPES)
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        return new ResponseEntity<>(itemService.getAllRecipes(), HttpStatus.OK);
    }
}

package fr.phoenyx.arena.services.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.enums.item.ItemRecipe;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.item.ItemMapper;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.item.ItemRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class ItemService extends CrudService<Item, ItemDTO> {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    protected JpaRepository<Item, Long> getRepository() {
        return itemRepository;
    }

    @Override
    protected Mapper<Item, ItemDTO> getMapper() {
        return new ItemMapper();
    }

    @Override
    protected Class<Item> getConcernedClass() {
        return Item.class;
    }

    @Override
    public ItemDTO create(ItemDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public ItemDTO update(ItemDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    public List<RecipeDTO> getAllRecipes() {
        return Arrays.stream(ItemRecipe.values())
                .map(RecipeDTO::new)
                .collect(Collectors.toList());
    }
}

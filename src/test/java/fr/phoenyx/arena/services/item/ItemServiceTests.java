package fr.phoenyx.arena.services.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.item.ItemBuilder;
import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.enums.item.ItemRecipe;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.item.ItemRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTests extends CrudServiceTests<Item, Long, ItemDTO> {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Override
    protected JpaRepository<Item, Long> getRepository() {
        return itemRepository;
    }

    @Override
    protected CrudService<Item, Long, ItemDTO> getService() {
        return itemService;
    }

    @Override
    protected Class<Item> getConcernedClass() {
        return Item.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Item buildEntity() {
        return new ItemBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Item> buildEntities() {
        return Arrays.asList(buildEntity());
    }

    @Test
    public void getAllRecipes_shouldReturnList() {
        //When
        List<RecipeDTO> recipes = itemService.getAllRecipes();

        //Then
        assertThat(recipes).isNotNull();
        assertThat(recipes).hasSize(ItemRecipe.values().length);
    }
}

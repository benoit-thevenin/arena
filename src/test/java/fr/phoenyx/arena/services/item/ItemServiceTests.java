package fr.phoenyx.arena.services.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.MessagesConstants.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.dtos.item.RecipeDTO;
import fr.phoenyx.arena.enums.item.ItemRecipe;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.item.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTests {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        Item item = new Item();
        item.setId(GENERIC_ID);
        List<Item> items = Arrays.asList(item);
        when(itemRepository.findAll()).thenReturn(items);

        //When
        List<ItemDTO> itemDTOs = itemService.findAll();

        //Then
        assertThat(itemDTOs).hasSize(items.size());
    }

    @Test
    public void findById_shouldReturnItem_whenExists() {
        //Given
        Item item = new Item();
        item.setId(GENERIC_ID);
        when(itemRepository.findById(GENERIC_ID)).thenReturn(Optional.of(item));

        //When
        ItemDTO itemDTO = itemService.findById(GENERIC_ID);

        //Then
        assertThat(itemDTO).isNotNull();
        assertThat(itemDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", Item.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(itemRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        itemService.findById(GENERIC_ID);
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

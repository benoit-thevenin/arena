package fr.phoenyx.arena.services.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
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
import fr.phoenyx.arena.enums.item.ItemType;
import fr.phoenyx.arena.enums.item.Power;
import fr.phoenyx.arena.enums.item.Rarity;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.item.ItemMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.item.ItemRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTests extends CrudServiceTests<Item, ItemDTO> {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Override
    protected JpaRepository<Item, Long> getRepository() {
        return itemRepository;
    }

    @Override
    protected CrudService<Item, ItemDTO> getService() {
        return itemService;
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
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Item buildEntity() {
        return new ItemBuilder()
                .name("name")
                .level(0)
                .quantity(0)
                .itemType(ItemType.values()[0])
                .rarity(Rarity.values()[0])
                .power(Power.values()[0])
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Item> buildEntities() {
        return Arrays.asList(buildEntity());
    }

    @Override
    @Test
    public void create_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
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

package fr.phoenyx.arena.controllers.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.RECIPES;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_ITEMS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.phoenyx.arena.advices.BadRequestAdvice;
import fr.phoenyx.arena.advices.EntityNotFoundAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.builders.item.ItemBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.enums.item.ItemType;
import fr.phoenyx.arena.enums.item.Power;
import fr.phoenyx.arena.enums.item.Rarity;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.item.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTests extends CrudControllerTests<Item, Long, ItemDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Item, Long, ItemDTO> getService() {
        return itemService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_ITEMS;
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
    protected ItemDTO buildDTO() {
        Bonus bonus = mock(Bonus.class);
        when(bonus.getCharacteristic()).thenReturn(Characteristic.values()[0]);
        Item item = new ItemBuilder()
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
        return new ItemDTO(item);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }

    @Test
    public void getAllRecipes_shouldReturnOK() throws Exception {
        mockMvc.perform(get(getEndpointRoot() + RECIPES))
                .andExpect(status().isOk());
    }
}

package fr.phoenyx.arena.controllers.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_BONUSES;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

import org.junit.Before;
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
import fr.phoenyx.arena.builders.item.BonusBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.item.BonusService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BonusControllerTests extends CrudControllerTests<Bonus, Long, BonusDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BonusService bonusService;

    @InjectMocks
    private BonusController bonusController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Bonus, Long, BonusDTO> getService() {
        return bonusService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_BONUSES;
    }

    @Override
    protected Class<Bonus> getConcernedClass() {
        return Bonus.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected BonusDTO buildDTO() {
        Bonus bonus = new BonusBuilder()
                .characteristic(Characteristic.values()[0])
                .rand(1.0)
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
        return new BonusDTO(bonus);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bonusController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}

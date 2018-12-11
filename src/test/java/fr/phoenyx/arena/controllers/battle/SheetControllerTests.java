package fr.phoenyx.arena.controllers.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

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
import fr.phoenyx.arena.builders.battle.SheetBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.SheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SheetControllerTests extends CrudControllerTests<Sheet, Long, SheetDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SheetService sheetService;

    @InjectMocks
    private SheetController sheetController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Sheet, Long, SheetDTO> getService() {
        return sheetService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/sheets";
    }

    @Override
    protected Class<Sheet> getConcernedClass() {
        return Sheet.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected SheetDTO buildDTO() {
        Sheet sheet = new SheetBuilder()
                .id(GENERIC_ID).build();
        return new SheetDTO(sheet);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(sheetController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}

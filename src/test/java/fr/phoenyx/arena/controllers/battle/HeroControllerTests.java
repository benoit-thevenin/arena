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
import fr.phoenyx.arena.builders.battle.HeroBuilder;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.HeroService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HeroControllerTests extends CrudControllerTests<Hero, Long, HeroDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HeroService heroService;

    @InjectMocks
    private HeroController heroController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Hero, Long, HeroDTO> getService() {
        return heroService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/heroes";
    }

    @Override
    protected Class<Hero> getConcernedClass() {
        return Hero.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected HeroDTO buildDTO() {
        Hero hero = new HeroBuilder()
                .id(GENERIC_ID).build();
        return new HeroDTO(hero);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(heroController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}

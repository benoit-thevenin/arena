package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.battle.HeroBuilder;
import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.repositories.battle.HeroRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroServiceTests extends CrudServiceTests<Hero, Long, HeroDTO> {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroService heroService;

    @Override
    protected JpaRepository<Hero, Long> getRepository() {
        return heroRepository;
    }

    @Override
    protected CrudService<Hero, Long, HeroDTO> getService() {
        return heroService;
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
    protected Hero buildEntity() {
        return new HeroBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Hero> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

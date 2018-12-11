package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
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
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.HeroMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.battle.Sheet;
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
    protected Mapper<Hero, HeroDTO> getMapper() {
        return new HeroMapper();
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
        return new HeroBuilder()
                .level(0)
                .heroBuild(mock(HeroBuild.class))
                .sheet(mock(Sheet.class))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Hero> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

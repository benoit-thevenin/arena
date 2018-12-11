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

import fr.phoenyx.arena.builders.battle.HeroBuildBuilder;
import fr.phoenyx.arena.dtos.battle.HeroBuildDTO;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroBuildServiceTests extends CrudServiceTests<HeroBuild, Long, HeroBuildDTO> {

    @Mock
    private HeroBuildRepository heroBuildRepository;

    @InjectMocks
    private HeroBuildService heroBuildService;

    @Override
    protected JpaRepository<HeroBuild, Long> getRepository() {
        return heroBuildRepository;
    }

    @Override
    protected CrudService<HeroBuild, Long, HeroBuildDTO> getService() {
        return heroBuildService;
    }

    @Override
    protected Class<HeroBuild> getConcernedClass() {
        return HeroBuild.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected HeroBuild buildEntity() {
        return new HeroBuildBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<HeroBuild> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

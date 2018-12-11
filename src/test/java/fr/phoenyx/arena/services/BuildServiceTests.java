package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.BuildBuilder;
import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.repositories.BuildRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildServiceTests extends CrudServiceTests<Build, Long, BuildDTO> {

    @Mock
    private BuildRepository buildRepository;

    @InjectMocks
    private BuildService buildService;

    @Override
    protected JpaRepository<Build, Long> getRepository() {
        return buildRepository;
    }

    @Override
    protected CrudService<Build, Long, BuildDTO> getService() {
        return buildService;
    }

    @Override
    protected Class<Build> getConcernedClass() {
        return Build.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Build buildEntity() {
        return new BuildBuilder().id(GENERIC_ID).build();
    }

    @Override
    protected List<Build> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

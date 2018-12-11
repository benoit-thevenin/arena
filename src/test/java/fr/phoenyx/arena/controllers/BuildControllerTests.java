package fr.phoenyx.arena.controllers;

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
import fr.phoenyx.arena.builders.BuildBuilder;
import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.services.BuildService;
import fr.phoenyx.arena.services.CrudService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuildControllerTests extends CrudControllerTests<Build, Long, BuildDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BuildService buildService;

    @InjectMocks
    private BuildController buildController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<Build, Long, BuildDTO> getService() {
        return buildService;
    }

    @Override
    protected String getEndpointRoot() {
        return "/builds";
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
    protected BuildDTO buildDTO() {
        Build build = new BuildBuilder()
                .id(GENERIC_ID).build();
        return new BuildDTO(build);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(buildController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}

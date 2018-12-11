package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.BuildBuilder;
import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.enums.Specialization;
import fr.phoenyx.arena.enums.Type;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.mappers.BuildMapper;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
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
    protected Mapper<Build, BuildDTO> getMapper() {
        return new BuildMapper();
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
        ActiveSkill activeSkill = mock(ActiveSkill.class);
        PassiveSkill passiveSkill = mock(PassiveSkill.class);
        when(activeSkill.getActiveSkillEnum()).thenReturn(ActiveSkillEnum.values()[0]);
        when(passiveSkill.getPassiveSkillEnum()).thenReturn(PassiveSkillEnum.values()[0]);
        return new BuildBuilder()
                .owner(mock(Player.class))
                .vitality(0)
                .strength(0)
                .intelligence(0)
                .agility(0)
                .activeSkills(Arrays.asList(activeSkill))
                .passiveSkills(Arrays.asList(passiveSkill))
                .stuff(Arrays.asList(mock(Item.class)))
                .specialization(Specialization.values()[0])
                .types(new HashSet<>(Arrays.asList(Type.values()[0])))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Build> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

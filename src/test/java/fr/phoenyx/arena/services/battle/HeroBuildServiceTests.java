package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
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
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.HeroBuildMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
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
    protected Mapper<HeroBuild, HeroBuildDTO> getMapper() {
        return new HeroBuildMapper();
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
        ActiveSkill activeSkill = mock(ActiveSkill.class);
        PassiveSkill passiveSkill = mock(PassiveSkill.class);
        when(activeSkill.getActiveSkillEnum()).thenReturn(ActiveSkillEnum.values()[0]);
        when(passiveSkill.getPassiveSkillEnum()).thenReturn(PassiveSkillEnum.values()[0]);
        return new HeroBuildBuilder()
                .heroes(Arrays.asList(mock(Hero.class)))
                .vitality(0)
                .strength(0)
                .intelligence(0)
                .agility(0)
                .activeSkills(Arrays.asList(activeSkill))
                .passiveSkills(Arrays.asList(passiveSkill))
                .stuff(Arrays.asList(mock(Item.class)))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<HeroBuild> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

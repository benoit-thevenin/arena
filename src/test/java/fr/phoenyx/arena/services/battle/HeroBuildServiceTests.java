package fr.phoenyx.arena.services.battle;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;
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
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.HeroBuildMapper;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.models.social.Player;
import fr.phoenyx.arena.repositories.battle.HeroBuildRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroBuildServiceTests extends CrudServiceTests<HeroBuild, HeroBuildDTO> {

    @Mock
    private HeroBuildRepository heroBuildRepository;

    @InjectMocks
    private HeroBuildService heroBuildService;

    @Override
    protected JpaRepository<HeroBuild, Long> getRepository() {
        return heroBuildRepository;
    }

    @Override
    protected CrudService<HeroBuild, HeroBuildDTO> getService() {
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
                .heroes(new HashSet<>(Arrays.asList(mock(Hero.class))))
                .vitality(0)
                .strength(0)
                .intelligence(0)
                .agility(0)
                .activeSkills(new HashSet<>(Arrays.asList(activeSkill)))
                .passiveSkills(new HashSet<>(Arrays.asList(passiveSkill)))
                .stuff(Arrays.asList(mock(Item.class)))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    @Test
    public void create_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

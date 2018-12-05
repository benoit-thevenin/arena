package fr.phoenyx.arena.services.skill;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.MessagesConstants.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.dtos.skill.ActiveSkillDTO;
import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.repositories.skill.ActiveSkillRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveSkillServiceTests {

    @Mock
    private ActiveSkillRepository activeSkillRepository;

    @InjectMocks
    private ActiveSkillService activeSkillService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        ActiveSkill activeSkill = new ActiveSkill();
        activeSkill.setId(GENERIC_ID);
        activeSkill.setActiveSkillEnum(ActiveSkillEnum.ARCANES_MISSILE);
        List<ActiveSkill> activeSkills = Arrays.asList(activeSkill);
        when(activeSkillRepository.findAll()).thenReturn(activeSkills);

        //When
        List<ActiveSkillDTO> applicantDTOs = activeSkillService.findAll();

        //Then
        assertThat(applicantDTOs).hasSize(activeSkills.size());
    }

    @Test
    public void findById_shouldReturnActiveSkill_whenExists() {
        //Given
        ActiveSkill activeSkill = new ActiveSkill();
        activeSkill.setId(GENERIC_ID);
        activeSkill.setActiveSkillEnum(ActiveSkillEnum.ARCANES_MISSILE);
        when(activeSkillRepository.findById(GENERIC_ID)).thenReturn(Optional.of(activeSkill));

        //When
        ActiveSkillDTO activeSkillDTO = activeSkillService.findById(GENERIC_ID);

        //Then
        assertThat(activeSkillDTO).isNotNull();
        assertThat(activeSkillDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", ActiveSkill.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(activeSkillRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        activeSkillService.findById(GENERIC_ID);
    }
}

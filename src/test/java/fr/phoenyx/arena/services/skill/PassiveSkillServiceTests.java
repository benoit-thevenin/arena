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

import fr.phoenyx.arena.dtos.skill.PassiveSkillDTO;
import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.repositories.skill.PassiveSkillRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassiveSkillServiceTests {

    @Mock
    private PassiveSkillRepository passiveSkillRepository;

    @InjectMocks
    private PassiveSkillService passiveSkillService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        PassiveSkill passiveSkill = new PassiveSkill();
        passiveSkill.setId(GENERIC_ID);
        passiveSkill.setPassiveSkillEnum(PassiveSkillEnum.BRUTE);
        List<PassiveSkill> passiveSkills = Arrays.asList(passiveSkill);
        when(passiveSkillRepository.findAll()).thenReturn(passiveSkills);

        //When
        List<PassiveSkillDTO> passiveSkillDTOs = passiveSkillService.findAll();

        //Then
        assertThat(passiveSkillDTOs).hasSize(passiveSkills.size());
    }

    @Test
    public void findById_shouldReturnPassiveSkill_whenExists() {
        //Given
        PassiveSkill passiveSkill = new PassiveSkill();
        passiveSkill.setId(GENERIC_ID);
        passiveSkill.setPassiveSkillEnum(PassiveSkillEnum.BRUTE);
        when(passiveSkillRepository.findById(GENERIC_ID)).thenReturn(Optional.of(passiveSkill));

        //When
        PassiveSkillDTO passiveSkillDTO = passiveSkillService.findById(GENERIC_ID);

        //Then
        assertThat(passiveSkillDTO).isNotNull();
        assertThat(passiveSkillDTO.getId()).isEqualTo(GENERIC_ID);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() {
        //Given
        exceptionRule.expect(GenericEntityException.class);
        String message = String.join(" ", PassiveSkill.class.getSimpleName(), NOT_FOUND, Long.toString(GENERIC_ID));
        exceptionRule.expectMessage(message);
        when(passiveSkillRepository.findById(GENERIC_ID)).thenReturn(Optional.empty());

        //When Then
        passiveSkillService.findById(GENERIC_ID);
    }
}

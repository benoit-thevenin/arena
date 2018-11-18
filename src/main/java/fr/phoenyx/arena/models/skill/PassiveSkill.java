package fr.phoenyx.arena.models.skill;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PASSIVE_SKILL")
public class PassiveSkill extends GenericEntity {

    @Enumerated(EnumType.STRING)
    private PassiveSkillEnum passiveSkill;
}

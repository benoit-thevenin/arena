package fr.phoenyx.arena.models.skill;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_PASSIVE_SKILL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_PASSIVE_SKILLS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.PassiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_PASSIVE_SKILLS)
public class PassiveSkill extends GenericEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_BUILD)
    private Build build;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_PASSIVE_SKILL, nullable = false)
    private PassiveSkillEnum passiveSkillEnum;
}

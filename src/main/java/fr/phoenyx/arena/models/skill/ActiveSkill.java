package fr.phoenyx.arena.models.skill;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ACTIVE_SKILL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_STRATEGY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_ACTIVE_SKILLS;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_ACTIVE_SKILLS)
public class ActiveSkill extends GenericEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_BUILD)
    private Build build;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_ACTIVE_SKILL, nullable = false)
    private ActiveSkillEnum activeSkill;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = COLUMN_ID_STRATEGY)
    private Strategy strategy;
}

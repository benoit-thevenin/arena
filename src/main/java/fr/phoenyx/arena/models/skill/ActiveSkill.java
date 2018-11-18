package fr.phoenyx.arena.models.skill;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.ActiveSkillEnum;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ACTIVE_SKILL")
public class ActiveSkill extends GenericEntity {

    @Enumerated(EnumType.STRING)
    private ActiveSkillEnum activeSkill;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ACTIVE_SKILL")
    private Strategy strategy;
}

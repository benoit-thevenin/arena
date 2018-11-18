package fr.phoenyx.arena.models.skill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "STRATEGY")
public class Strategy extends GenericEntity {

    @Column(name = "TARGET_PREDICATE")
    private String targetPredicate;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "IS_BUFF")
    private boolean buff;
}

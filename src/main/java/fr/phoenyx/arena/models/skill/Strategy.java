package fr.phoenyx.arena.models.skill;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_IS_BUFF;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_PRIORITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_TARGET_PREDICATE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_STRATEGIES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_STRATEGIES)
public class Strategy extends GenericEntity {

    @Column(name = COLUMN_TARGET_PREDICATE)
    private String targetPredicate;

    @Column(name = COLUMN_PRIORITY, nullable = false)
    private int priority;

    @Column(name = COLUMN_IS_BUFF, nullable = false)
    private boolean buff;
}

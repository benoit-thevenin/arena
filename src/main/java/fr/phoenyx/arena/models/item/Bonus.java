package fr.phoenyx.arena.models.item;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_CHARACTERISTIC;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_RAND;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_BONUSES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.item.Characteristic;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_BONUSES)
public class Bonus extends GenericEntity {

    @Enumerated
    @Column(name = COLUMN_CHARACTERISTIC, nullable = false)
    private Characteristic characteristic;

    @Column(name = COLUMN_RAND, nullable = false)
    private double rand;
}

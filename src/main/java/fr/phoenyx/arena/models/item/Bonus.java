package fr.phoenyx.arena.models.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BONUS")
public class Bonus extends GenericEntity {

    @Enumerated
    private Characteristic characteristic;

    @Column(name = "RAND")
    private double rand;
}

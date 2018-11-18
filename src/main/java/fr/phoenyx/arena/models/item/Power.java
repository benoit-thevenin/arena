package fr.phoenyx.arena.models.item;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "POWER")
public class Power extends GenericEntity {

    //TODO should this be an enum ?
}

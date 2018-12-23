package fr.phoenyx.arena.models.social;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_TRADE_OFFERS)
public class TradeOffer extends GenericEntity {

}

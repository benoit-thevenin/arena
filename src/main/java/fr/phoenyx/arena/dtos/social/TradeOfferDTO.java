package fr.phoenyx.arena.dtos.social;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.social.TradeOffer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TradeOfferDTO extends GenericEntityDTO {

    public TradeOfferDTO() {
        super();
    }

    public TradeOfferDTO(TradeOffer tradeOffer) {
        super(tradeOffer);
    }
}

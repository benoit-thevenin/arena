package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.TradeOfferDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.TradeOffer;

public class TradeOfferMapper implements Mapper<TradeOffer, TradeOfferDTO> {

    @Override
    public TradeOfferDTO entityToDto(TradeOffer entity) {
        return new TradeOfferDTO(entity);
    }
}

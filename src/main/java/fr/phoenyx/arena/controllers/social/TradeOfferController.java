package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_TRADE_OFFERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.TradeOfferDTO;
import fr.phoenyx.arena.models.social.TradeOffer;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.TradeOfferService;

@RestController
@RequestMapping(ROOT_TRADE_OFFERS)
public class TradeOfferController extends CrudController<TradeOffer, TradeOfferDTO> {

    @Autowired
    private TradeOfferService tradeOfferService;

    @Override
    protected CrudService<TradeOffer, TradeOfferDTO> getService() {
        return tradeOfferService;
    }
}

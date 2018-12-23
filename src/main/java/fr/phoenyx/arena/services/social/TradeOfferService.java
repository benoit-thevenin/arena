package fr.phoenyx.arena.services.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.social.TradeOfferDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.TradeOfferMapper;
import fr.phoenyx.arena.models.social.TradeOffer;
import fr.phoenyx.arena.repositories.social.TradeOfferRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class TradeOfferService extends CrudService<TradeOffer, TradeOfferDTO> {

    @Autowired
    private TradeOfferRepository tradeOfferRepository;

    @Override
    protected JpaRepository<TradeOffer, Long> getRepository() {
        return tradeOfferRepository;
    }

    @Override
    protected Mapper<TradeOffer, TradeOfferDTO> getMapper() {
        return new TradeOfferMapper();
    }

    @Override
    protected Class<TradeOffer> getConcernedClass() {
        return TradeOffer.class;
    }

    @Override
    public TradeOfferDTO create(TradeOfferDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TradeOfferDTO update(TradeOfferDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}

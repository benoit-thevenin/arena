package fr.phoenyx.arena.repositories.social;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.social.TradeOffer;

@Repository
public interface TradeOfferRepository extends JpaRepository<TradeOffer, Long> {

}

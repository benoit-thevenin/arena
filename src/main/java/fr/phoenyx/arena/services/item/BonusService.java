package fr.phoenyx.arena.services.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.repositories.item.BonusRepository;

@Service
public class BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    public List<Bonus> getAllBonuses() {
        return bonusRepository.findAll();
    }
}

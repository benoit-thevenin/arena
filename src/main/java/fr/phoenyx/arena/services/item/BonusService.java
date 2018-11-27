package fr.phoenyx.arena.services.item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.repositories.item.BonusRepository;

@Service
public class BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    public List<BonusDTO> getAllBonuses() {
        return bonusRepository.findAll().stream()
                .map(BonusDTO::new)
                .collect(Collectors.toList());
    }
}

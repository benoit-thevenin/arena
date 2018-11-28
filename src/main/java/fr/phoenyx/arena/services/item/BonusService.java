package fr.phoenyx.arena.services.item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.exceptions.item.BonusException;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.repositories.item.BonusRepository;

@Service
public class BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    public List<BonusDTO> findAll() {
        return bonusRepository.findAll().stream()
                .map(BonusDTO::new)
                .collect(Collectors.toList());
    }

    public BonusDTO findById(Long id) {
        Bonus bonus = bonusRepository.findById(id)
                .orElseThrow(() -> BonusException.entityNotFound(id));
        return new BonusDTO(bonus);
    }
}

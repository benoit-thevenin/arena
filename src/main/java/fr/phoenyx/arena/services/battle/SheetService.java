package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.exceptions.battle.SheetException;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.repositories.battle.SheetRepository;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetRepository;

    public List<SheetDTO> findAll() {
        return sheetRepository.findAll().stream()
                .map(SheetDTO::new)
                .collect(Collectors.toList());
    }

    public SheetDTO findById(Long id) {
        Sheet sheet = sheetRepository.findById(id)
                .orElseThrow(() -> SheetException.entityNotFound(id));
        return new SheetDTO(sheet);
    }
}

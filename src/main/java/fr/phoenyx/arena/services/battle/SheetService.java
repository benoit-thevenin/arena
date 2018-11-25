package fr.phoenyx.arena.services.battle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.repositories.battle.SheetRepository;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetRepository;

    public List<SheetDTO> getAllSheets() {
        return sheetRepository.findAll().stream()
                .map(sheet -> new SheetDTO(sheet))
                .collect(Collectors.toList());
    }
}

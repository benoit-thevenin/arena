package fr.phoenyx.arena.services.battle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.repositories.battle.SheetRepository;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetRepository;

    public List<Sheet> getAllSheets() {
        return sheetRepository.findAll();
    }
}

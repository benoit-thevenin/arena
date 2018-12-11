package fr.phoenyx.arena.controllers.battle;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_SHEETS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.battle.SheetService;

@RestController
@RequestMapping(ROOT_SHEETS)
public class SheetController extends CrudController<Sheet, Long, SheetDTO> {

    @Autowired
    private SheetService sheetService;

    @Override
    protected CrudService<Sheet, Long, SheetDTO> getService() {
        return sheetService;
    }
}

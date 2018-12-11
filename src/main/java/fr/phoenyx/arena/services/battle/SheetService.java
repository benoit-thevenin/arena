package fr.phoenyx.arena.services.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.SheetDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.SheetMapper;
import fr.phoenyx.arena.models.battle.Sheet;
import fr.phoenyx.arena.repositories.battle.SheetRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class SheetService extends CrudService<Sheet, Long, SheetDTO> {

    @Autowired
    private SheetRepository sheetRepository;

    @Override
    protected JpaRepository<Sheet, Long> getRepository() {
        return sheetRepository;
    }

    @Override
    protected Mapper<Sheet, SheetDTO> getMapper() {
        return new SheetMapper();
    }

    @Override
    protected Class<Sheet> getConcernedClass() {
        return Sheet.class;
    }
}

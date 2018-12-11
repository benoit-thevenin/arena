package fr.phoenyx.arena.services.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.battle.HeroDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.battle.HeroMapper;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.repositories.battle.HeroRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class HeroService extends CrudService<Hero, Long, HeroDTO> {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    protected JpaRepository<Hero, Long> getRepository() {
        return heroRepository;
    }

    @Override
    protected Mapper<Hero, HeroDTO> getMapper() {
        return new HeroMapper();
    }

    @Override
    protected Class<Hero> getConcernedClass() {
        return Hero.class;
    }
}

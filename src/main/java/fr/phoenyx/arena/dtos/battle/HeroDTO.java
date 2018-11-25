package fr.phoenyx.arena.dtos.battle;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.battle.Hero;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HeroDTO extends GenericEntityDTO {

    private int level;
    private HeroBuildDTO heroBuild;
    private SheetDTO sheet;

    public HeroDTO() {
        super();
    }

    public HeroDTO(Hero hero) {
        super(hero);
        level = hero.getLevel();
        heroBuild = new HeroBuildDTO(hero.getHeroBuild());
        sheet = new SheetDTO(hero.getSheet());
    }
}

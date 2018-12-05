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
        if (hero.getHeroBuild() != null) {
            heroBuild = new HeroBuildDTO(hero.getHeroBuild());
        }
        if (hero.getSheet() != null) {
            sheet = new SheetDTO(hero.getSheet());
        }
    }
}

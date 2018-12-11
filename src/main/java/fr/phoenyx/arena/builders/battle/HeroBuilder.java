package fr.phoenyx.arena.builders.battle;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.battle.Sheet;

public class HeroBuilder extends GenericEntityBuilder<Hero> {

    private Hero hero;

    public HeroBuilder() {
        hero = new Hero();
    }

    @Override
    protected Hero getEntity() {
        return hero;
    }

    public HeroBuilder level(int level) {
        hero.setLevel(level);
        return this;
    }

    public HeroBuilder heroBuild(HeroBuild heroBuild) {
        hero.setHeroBuild(heroBuild);
        return this;
    }

    public HeroBuilder sheet(Sheet sheet) {
        hero.setSheet(sheet);
        return this;
    }
}

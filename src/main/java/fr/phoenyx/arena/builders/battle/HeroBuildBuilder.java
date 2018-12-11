package fr.phoenyx.arena.builders.battle;

import java.util.List;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.HeroBuild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;

public class HeroBuildBuilder extends GenericEntityBuilder<HeroBuild> {

    private HeroBuild heroBuild;

    public HeroBuildBuilder() {
        heroBuild = new HeroBuild();
    }

    @Override
    protected HeroBuild getEntity() {
        return heroBuild;
    }

    public HeroBuildBuilder heroes(List<Hero> heroes) {
        heroBuild.setHeroes(heroes);
        return this;
    }

    public HeroBuildBuilder vitality(int vitality) {
        heroBuild.setVitality(vitality);
        return this;
    }

    public HeroBuildBuilder strength(int strength) {
        heroBuild.setStrength(strength);
        return this;
    }

    public HeroBuildBuilder intelligence(int intelligence) {
        heroBuild.setIntelligence(intelligence);
        return this;
    }

    public HeroBuildBuilder agility(int agility) {
        heroBuild.setAgility(agility);
        return this;
    }

    public HeroBuildBuilder activeSkills(List<ActiveSkill> activeSkills) {
        heroBuild.setActiveSkills(activeSkills);
        return this;
    }

    public HeroBuildBuilder passiveSkills(List<PassiveSkill> passiveSkills) {
        heroBuild.setPassiveSkills(passiveSkills);
        return this;
    }

    public HeroBuildBuilder stuff(List<Item> stuff) {
        heroBuild.setStuff(stuff);
        return this;
    }
}

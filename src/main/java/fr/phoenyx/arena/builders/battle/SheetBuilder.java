package fr.phoenyx.arena.builders.battle;

import java.util.List;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.skill.Effect;
import fr.phoenyx.arena.models.battle.Hero;
import fr.phoenyx.arena.models.battle.Sheet;

public class SheetBuilder extends GenericEntityBuilder<Sheet> {

    private Sheet sheet;

    public SheetBuilder() {
        sheet = new Sheet();
    }

    @Override
    protected Sheet getEntity() {
        return sheet;
    }

    public SheetBuilder hero(Hero hero) {
        sheet.setHero(hero);
        return this;
    }

    public SheetBuilder initHealth(int initHealth) {
        sheet.setInitHealth(initHealth);
        return this;
    }

    public SheetBuilder initMana(int initMana) {
        sheet.setInitMana(initMana);
        return this;
    }

    public SheetBuilder strength(int strength) {
        sheet.setStrength(strength);
        return this;
    }

    public SheetBuilder agility(int agility) {
        sheet.setAgility(agility);
        return this;
    }

    public SheetBuilder intelligence(int intelligence) {
        sheet.setIntelligence(intelligence);
        return this;
    }

    public SheetBuilder currentHealth(int currentHealth) {
        sheet.setCurrentHealth(currentHealth);
        return this;
    }

    public SheetBuilder currentMana(int currentMana) {
        sheet.setCurrentMana(currentMana);
        return this;
    }

    public SheetBuilder effects(List<Effect> effects) {
        sheet.setEffects(effects);
        return this;
    }
}

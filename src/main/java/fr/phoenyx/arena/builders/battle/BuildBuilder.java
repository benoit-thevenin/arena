package fr.phoenyx.arena.builders.battle;

import java.util.List;
import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.battle.Specialization;
import fr.phoenyx.arena.enums.battle.Type;
import fr.phoenyx.arena.models.battle.Build;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;
import fr.phoenyx.arena.models.social.Player;

public class BuildBuilder extends GenericEntityBuilder<Build> {

    private Build build;

    public BuildBuilder() {
        build = new Build();
    }

    @Override
    protected Build getEntity() {
        return build;
    }

    public BuildBuilder owner(Player owner) {
        build.setOwner(owner);
        return this;
    }

    public BuildBuilder vitality(int vitality) {
        build.setVitality(vitality);
        return this;
    }

    public BuildBuilder strength(int strength) {
        build.setStrength(strength);
        return this;
    }

    public BuildBuilder intelligence(int intelligence) {
        build.setIntelligence(intelligence);
        return this;
    }

    public BuildBuilder agility(int agility) {
        build.setAgility(agility);
        return this;
    }

    public BuildBuilder activeSkills(Set<ActiveSkill> activeSkills) {
        build.setActiveSkills(activeSkills);
        return this;
    }

    public BuildBuilder passiveSkills(Set<PassiveSkill> passiveSkills) {
        build.setPassiveSkills(passiveSkills);
        return this;
    }

    public BuildBuilder stuff(List<Item> stuff) {
        build.setStuff(stuff);
        return this;
    }

    public BuildBuilder specialization(Specialization specialization) {
        build.setSpecialization(specialization);
        return this;
    }

    public BuildBuilder types(Set<Type> types) {
        build.setTypes(types);
        return this;
    }
}

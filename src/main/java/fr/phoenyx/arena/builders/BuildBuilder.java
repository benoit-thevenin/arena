package fr.phoenyx.arena.builders;

import java.util.List;
import java.util.Set;

import fr.phoenyx.arena.enums.Specialization;
import fr.phoenyx.arena.enums.Type;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.skill.ActiveSkill;
import fr.phoenyx.arena.models.skill.PassiveSkill;

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

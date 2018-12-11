package fr.phoenyx.arena.builders.item;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.models.item.Bonus;

public class BonusBuilder extends GenericEntityBuilder<Bonus> {

    private Bonus bonus;

    public BonusBuilder() {
        bonus = new Bonus();
    }

    @Override
    protected Bonus getEntity() {
        return bonus;
    }

    public BonusBuilder characteristic(Characteristic characteristic) {
        bonus.setCharacteristic(characteristic);
        return this;
    }

    public BonusBuilder rand(double rand) {
        bonus.setRand(rand);
        return this;
    }
}

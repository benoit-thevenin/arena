package fr.phoenyx.arena.builders.item;

import java.util.List;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.item.ItemType;
import fr.phoenyx.arena.enums.item.Power;
import fr.phoenyx.arena.enums.item.Rarity;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.models.item.Item;

public class ItemBuilder extends GenericEntityBuilder<Item> {

    private Item item;

    public ItemBuilder() {
        item = new Item();
    }

    @Override
    protected Item getEntity() {
        return item;
    }

    public ItemBuilder name(String name) {
        item.setName(name);
        return this;
    }

    public ItemBuilder level(int level) {
        item.setLevel(level);
        return this;
    }

    public ItemBuilder quantity(int quantity) {
        item.setQuantity(quantity);
        return this;
    }

    public ItemBuilder itemType(ItemType itemType) {
        item.setItemType(itemType);
        return this;
    }

    public ItemBuilder rarity(Rarity rarity) {
        item.setRarity(rarity);
        return this;
    }

    public ItemBuilder bonuses(List<Bonus> bonuses) {
        item.setBonuses(bonuses);
        return this;
    }

    public ItemBuilder power(Power power) {
        item.setPower(power);
        return this;
    }
}

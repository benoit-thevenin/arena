package fr.phoenyx.arena.enums.item;

public enum ItemType {
    HELMET("Head", ItemSlot.HEAD),
    PAULDRONS("Pauldrons", ItemSlot.SHOULDERS),
    GLOVES("Gloves", ItemSlot.HANDS),
    CHEST_ARMOR("Chest armor", ItemSlot.TORSO),
    PANTS("Pants", ItemSlot.LEGS),
    BOOTS("Boots", ItemSlot.FEET),
    BELT("Belt", ItemSlot.BELT),
    BRACERS("Bracers", ItemSlot.WRIST),
    RING("Ring", ItemSlot.FINGER1, ItemSlot.FINGER2),
    NECKLACE("Necklace", ItemSlot.NECK),
    WEAPON("Weapon", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    OFF_HAND("Off hand", ItemSlot.LEFT_HAND);

    private String description;
    private ItemSlot[] itemSlots;

    ItemType(String description, ItemSlot... itemSlots) {
        this.description = description;
        this.itemSlots = itemSlots;
    }

    public String getDescription() {
        return description;
    }

    public ItemSlot[] getItemSlots() {
        return itemSlots;
    }
}

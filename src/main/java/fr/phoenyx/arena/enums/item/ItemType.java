package fr.phoenyx.arena.enums.item;

public enum ItemType {
    MATERIAL("Material"),
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
    //One handed weapons
    SWORD("Sword", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    DAGGER("Dagger", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    MACE("Mace", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    AXE("Axe", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    WAND("Wand", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    FIST_WEAPON("Fist weapon", ItemSlot.RIGHT_HAND, ItemSlot.LEFT_HAND),
    //Two handed weapons
    POLEARM("Polearm", ItemSlot.RIGHT_HAND),
    STAFF("Staff", ItemSlot.RIGHT_HAND),
    TWO_HANDED_SWORD("Two handed sword", ItemSlot.RIGHT_HAND),
    TWO_HANDED_MACE("Two Handed mace", ItemSlot.RIGHT_HAND),
    TWO_HANDED_AXE("Two handed axe", ItemSlot.RIGHT_HAND),
    //Off-hands
    SHIELD("Shield", ItemSlot.LEFT_HAND),
    QUIVER("Quiver", ItemSlot.LEFT_HAND),
    MAGIC_ORB("Magic orb", ItemSlot.LEFT_HAND);

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

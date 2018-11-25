package fr.phoenyx.arena.dtos.item;

import fr.phoenyx.arena.enums.item.ItemSlot;
import lombok.Data;

@Data
public class ItemSlotDTO {

    private String description;

    public ItemSlotDTO() {
        super();
    }

    public ItemSlotDTO(ItemSlot itemSlot) {
        this();
        description = itemSlot.getDescription();
    }
}

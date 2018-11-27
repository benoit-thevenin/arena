package fr.phoenyx.arena.dtos.item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.enums.item.ItemType;
import lombok.Data;

@Data
public class ItemTypeDTO {

    private String description;
    private List<ItemSlotDTO> itemSlots;

    public ItemTypeDTO() {
        super();
    }

    public ItemTypeDTO(ItemType itemType) {
        this();
        description = itemType.getDescription();
        if (itemType.getItemSlots() != null && itemType.getItemSlots().length > 0) {
            itemSlots = Arrays.stream(itemType.getItemSlots())
                    .map(ItemSlotDTO::new)
                    .collect(Collectors.toList());
        }
    }
}

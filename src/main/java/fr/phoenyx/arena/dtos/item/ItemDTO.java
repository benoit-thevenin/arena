package fr.phoenyx.arena.dtos.item;

import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ItemDTO extends GenericEntityDTO {

    private String name;
    private int level;
    private int quantity;
    private ItemTypeDTO itemType;
    private RarityDTO rarity;
    private List<BonusDTO> bonuses;
    private PowerDTO power;

    public ItemDTO() {
        super();
    }

    public ItemDTO(Item item) {
        super(item);
        name = item.getName();
        level = item.getLevel();
        quantity = item.getQuantity();
        if (item.getItemType() != null) {
            itemType = new ItemTypeDTO(item.getItemType());
        }
        if (item.getRarity() != null) {
            rarity = new RarityDTO(item.getRarity());
        }
        bonuses = item.getBonuses().stream()
                .map(bonus -> new BonusDTO(bonus))
                .collect(Collectors.toList());
        if (item.getPower() != null) {
            power = new PowerDTO(item.getPower());
        }
    }
}

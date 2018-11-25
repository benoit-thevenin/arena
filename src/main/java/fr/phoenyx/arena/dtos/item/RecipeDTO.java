package fr.phoenyx.arena.dtos.item;

import fr.phoenyx.arena.enums.item.ItemRecipe;
import lombok.Data;

@Data
public class RecipeDTO {

    private ItemTypeDTO itemType;
    private RarityDTO rarity;
    private int commonMaterialCost;
    private int magicMaterialCost;
    private int rareMaterialCost;
    private int epicMaterialCost;
    private int legendaryMaterialCost;

    public RecipeDTO() {
        super();
    }

    public RecipeDTO(ItemRecipe itemRecipe) {
        this();
        this.itemType = new ItemTypeDTO(itemRecipe.getItemType());
        this.rarity = new RarityDTO(itemRecipe.getRarity());
        this.commonMaterialCost = itemRecipe.getCommonMaterialCost();
        this.magicMaterialCost = itemRecipe.getMagicMaterialCost();
        this.rareMaterialCost = itemRecipe.getRareMaterialCost();
        this.epicMaterialCost = itemRecipe.getEpicMaterialCost();
        this.legendaryMaterialCost = itemRecipe.getLegendaryMaterialCost();
    }
}

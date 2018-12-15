package fr.phoenyx.arena.mappers.item;

import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.item.Item;

public class ItemMapper implements Mapper<Item, ItemDTO> {

    @Override
    public ItemDTO entityToDto(Item entity) {
        return new ItemDTO(entity);
    }
}

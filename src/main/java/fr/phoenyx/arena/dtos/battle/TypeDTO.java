package fr.phoenyx.arena.dtos.battle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.item.CharacteristicDTO;
import fr.phoenyx.arena.enums.battle.Type;
import lombok.Data;

@Data
public class TypeDTO {

    private String description;
    private List<CharacteristicDTO> characteristics;

    public TypeDTO() {
        super();
    }

    public TypeDTO(Type type) {
        this();
        description = type.getDescription();
        characteristics = Arrays.stream(type.getCharacteristics())
                .map(CharacteristicDTO::new)
                .collect(Collectors.toList());
    }
}

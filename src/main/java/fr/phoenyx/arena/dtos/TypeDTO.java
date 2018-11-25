package fr.phoenyx.arena.dtos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.phoenyx.arena.enums.Type;
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
                .map(characteristic -> new CharacteristicDTO(characteristic))
                .collect(Collectors.toList());
    }
}

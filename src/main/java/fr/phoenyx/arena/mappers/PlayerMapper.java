package fr.phoenyx.arena.mappers;

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.models.Player;

public class PlayerMapper implements Mapper<Player, PlayerDTO> {

    @Override
    public PlayerDTO entityToDto(Player entity) {
        return new PlayerDTO(entity);
    }

    @Override
    public Player dtoToEntity(PlayerDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

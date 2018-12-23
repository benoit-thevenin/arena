package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.PlayerDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Player;

public class PlayerMapper implements Mapper<Player, PlayerDTO> {

    @Override
    public PlayerDTO entityToDto(Player entity) {
        return new PlayerDTO(entity);
    }
}

package fr.phoenyx.arena.services;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.PlayerMapper;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.repositories.PlayerRepository;

@Service
public class PlayerService extends CrudService<Player, PlayerDTO> {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    protected JpaRepository<Player, Long> getRepository() {
        return playerRepository;
    }

    @Override
    protected Mapper<Player, PlayerDTO> getMapper() {
        return new PlayerMapper();
    }

    @Override
    protected Class<Player> getConcernedClass() {
        return Player.class;
    }

    @Override
    public PlayerDTO create(PlayerDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public PlayerDTO update(PlayerDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    public PlayerDTO findByEmail(String email) throws EntityNotFoundException {
        Player player = playerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(email));
        return new PlayerDTO(player);
    }
}

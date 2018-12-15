package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.PlayerBuilder;
import fr.phoenyx.arena.dtos.PlayerDTO;
import fr.phoenyx.arena.enums.GuildRole;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.PlayerMapper;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.Guild;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.repositories.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTests extends CrudServiceTests<Player, PlayerDTO> {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Override
    protected JpaRepository<Player, Long> getRepository() {
        return playerRepository;
    }

    @Override
    protected CrudService<Player, PlayerDTO> getService() {
        return playerService;
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
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Player buildEntity() {
        return new PlayerBuilder()
                .username("username")
                .email("email")
                .lastConnection(LocalDateTime.now())
                .gold(0)
                .level(0)
                .experience(0)
                .inventory(Arrays.asList(mock(Item.class)))
                .builds(new HashSet<>(Arrays.asList(mock(Build.class))))
                .guild(mock(Guild.class))
                .guildRole(GuildRole.values()[0])
                .friends(new HashSet<>(Arrays.asList(mock(Player.class))))
                .id(GENERIC_ID)
                .dateCreation(LocalDateTime.now())
                .dateModification(LocalDateTime.now())
                .modifier(mock(Player.class)).build();
    }

    @Override
    protected List<Player> buildEntities() {
        return Arrays.asList(buildEntity());
    }

    @Override
    @Test
    public void create_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void create_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldReturnDTO_whenOK() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowNotFoundException_whenNotExists() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    @Test
    public void update_shouldThrowBadRequestException_whenKO() throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}

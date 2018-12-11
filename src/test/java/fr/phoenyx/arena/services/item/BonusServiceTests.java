package fr.phoenyx.arena.services.item;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.builders.item.BonusBuilder;
import fr.phoenyx.arena.dtos.item.BonusDTO;
import fr.phoenyx.arena.enums.Characteristic;
import fr.phoenyx.arena.models.item.Bonus;
import fr.phoenyx.arena.repositories.item.BonusRepository;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.CrudServiceTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BonusServiceTests extends CrudServiceTests<Bonus, Long, BonusDTO> {

    @Mock
    private BonusRepository bonusRepository;

    @InjectMocks
    private BonusService bonusService;

    @Override
    protected JpaRepository<Bonus, Long> getRepository() {
        return bonusRepository;
    }

    @Override
    protected CrudService<Bonus, Long, BonusDTO> getService() {
        return bonusService;
    }

    @Override
    protected Class<Bonus> getConcernedClass() {
        return Bonus.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected Bonus buildEntity() {
        return new BonusBuilder()
                .characteristic(Characteristic.values()[0])
                .id(GENERIC_ID).build();
    }

    @Override
    protected List<Bonus> buildEntities() {
        return Arrays.asList(buildEntity());
    }
}

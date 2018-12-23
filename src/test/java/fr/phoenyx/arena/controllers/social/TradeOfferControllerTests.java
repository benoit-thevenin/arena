package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.GlobalConstants.GENERIC_ID;
import static fr.phoenyx.arena.constants.RestConstants.ROOT_TRADE_OFFERS;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.phoenyx.arena.advices.BadRequestAdvice;
import fr.phoenyx.arena.advices.EntityNotFoundAdvice;
import fr.phoenyx.arena.advices.GenericAdvice;
import fr.phoenyx.arena.controllers.CrudControllerTests;
import fr.phoenyx.arena.dtos.social.TradeOfferDTO;
import fr.phoenyx.arena.models.social.TradeOffer;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.TradeOfferService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TradeOfferControllerTests extends CrudControllerTests<TradeOffer, TradeOfferDTO> {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TradeOfferService tradeOfferService;

    @InjectMocks
    private TradeOfferController tradeOfferController;

    @Override
    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    protected CrudService<TradeOffer, TradeOfferDTO> getService() {
        return tradeOfferService;
    }

    @Override
    protected String getEndpointRoot() {
        return ROOT_TRADE_OFFERS;
    }

    @Override
    protected Class<TradeOffer> getConcernedClass() {
        return TradeOffer.class;
    }

    @Override
    protected Long getGenericId() {
        return GENERIC_ID;
    }

    @Override
    protected TradeOfferDTO buildDTO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(tradeOfferController)
                .setControllerAdvice(new GenericAdvice(), new EntityNotFoundAdvice(), new BadRequestAdvice())
                .build();
    }
}

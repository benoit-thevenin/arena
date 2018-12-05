package fr.phoenyx.arena.utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.phoenyx.arena.exceptions.GenericEntityException;
import fr.phoenyx.arena.models.GenericEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionUtilsTests {

    @Test
    public void exceptionStacktraceToString_shouldReturnString() {
        //Given
        GenericEntityException exception = GenericEntityException.entityNotFound(GenericEntity.class, "foo");

        //When Then
        assertThat(ExceptionUtils.exceptionStacktraceToString(exception)).isNotBlank();
    }
}

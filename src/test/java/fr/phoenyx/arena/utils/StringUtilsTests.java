package fr.phoenyx.arena.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilsTests {

    @Test
    public void isEmpty_shouldReturnTrue_whenNull() {
        assertThat(StringUtils.isEmpty(null)).isTrue();
    }

    @Test
    public void isEmpty_shouldReturnTrue_whenEmpty() {
        assertThat(StringUtils.isEmpty(StringUtils.EMPTY)).isTrue();
    }

    @Test
    public void isEmpty_shouldReturnFalse_whenFoo() {
        assertThat(StringUtils.isEmpty("foo")).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnFalse_whenNull() {
        assertThat(StringUtils.isNotEmpty(null)).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnFalse_whenEmpty() {
        assertThat(StringUtils.isNotEmpty(StringUtils.EMPTY)).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnTrue_whenFoo() {
        assertThat(StringUtils.isNotEmpty("foo")).isTrue();
    }
}

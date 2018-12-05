package fr.phoenyx.arena.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionUtilsTests {

    @Test
    public void isEmpty_shouldReturnTrue_whenNull() {
        assertThat(CollectionUtils.isEmpty(null)).isTrue();
    }

    @Test
    public void isEmpty_shouldReturnTrue_whenEmpty() {
        assertThat(CollectionUtils.isEmpty(Collections.emptyList())).isTrue();
    }

    @Test
    public void isEmpty_shouldReturnFalse_whenNotEmpty() {
        assertThat(CollectionUtils.isEmpty(Arrays.asList("foo"))).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnFalse_whenNull() {
        assertThat(CollectionUtils.isNotEmpty(null)).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnFalse_whenEmpty() {
        assertThat(CollectionUtils.isNotEmpty(Collections.emptyList())).isFalse();
    }

    @Test
    public void isNotEmpty_shouldReturnTrue_whenNotEmpty() {
        assertThat(CollectionUtils.isNotEmpty(Arrays.asList("foo"))).isTrue();
    }
}

package fr.phoenyx.arena.utils;

import java.util.Collection;

public class CollectionUtils {

    public static final boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public static final boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }
}

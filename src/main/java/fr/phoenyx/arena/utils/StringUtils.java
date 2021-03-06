package fr.phoenyx.arena.utils;

public class StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {}

    public static final boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static final boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}

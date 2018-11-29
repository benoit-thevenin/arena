package fr.phoenyx.arena.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExceptionUtils {

    private ExceptionUtils() {}

    public static final String exceptionStacktraceToString(Exception exception) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        exception.printStackTrace(ps);
        ps.close();
        return baos.toString();
    }
}

package br.com.balder.baldersatistics.util;

/**
 * @author Rogério Fontes
 */
public final class StringTestUtil {

    private static final String CHARACTER = "A";

    private StringTestUtil() {}

    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < length; index++) {
            builder.append(CHARACTER);
        }
        return builder.toString();
    }
}

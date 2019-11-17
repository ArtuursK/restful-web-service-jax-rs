package com.testapi.utility;

import java.util.Map;

public class EnvExtractor {

    private static Map<String, String> envVars = System.getenv();

    public static String getValue(String envVar) {
        final String value = envVars.get(envVar);
        return !isBlank(value) ? value : null;
    }

    private static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0)
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i)))
                return false;
        }
        return true;
    }
}

package org.utils;

import java.util.Map;

public class StringUtils {
    public static Map.Entry<String, String> stringToPair (String text) {
        if(checkStringIsEmpty(text))
            throw new IllegalStateException();
        if(!text.contains(" "))
            throw new IllegalStateException("text not contain pair of string");

        String[] stringArray = splitText("\\s+", text);
        Map.Entry<String, String> entry = Map.entry(stringArray[0], stringArray[1]);

        return entry;
    }

    public static String[] splitText(String regex, String text){
        return text.split(regex);
    }

    public static boolean checkStringIsEmpty(String text){
        if(text.isEmpty())
            throw new IllegalStateException ("text is empty");
        return false;
    }
}

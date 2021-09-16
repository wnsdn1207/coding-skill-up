package own.junn.practice.test;

import java.util.regex.Pattern;

public class RegexUtil {
    public static boolean startBy(String text, String regex) {
        return text.matches("^" + Pattern.quote(regex));
    }
}

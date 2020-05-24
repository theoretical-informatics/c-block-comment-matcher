import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright 2020 by Bajupa.com
 * Created by peter on 24.05.20.
 */
public class RegexDemo {
    public static Matcher getCommentMatcherFor(String givenString) {
        Pattern pattern = Pattern.compile("/\\*a?\\*/");
        return pattern.matcher(givenString);
    }
}

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright 2020 by Bajupa.com
 * Created by peter on 24.05.20.
 */
class RegexDemoTest {
    @Test
    void itShouldMatchAnEmptyComment() {
        // arrange
        Matcher matcher = RegexDemo.getCommentMatcherFor("/**/");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldNotMatchSomeOtherStringWithoutComment() {
        // arrange
        Matcher matcher = RegexDemo.getCommentMatcherFor("class");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertFalse(groupFound);
    }
}
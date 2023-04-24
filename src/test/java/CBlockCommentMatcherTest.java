import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright 2020 by Bajupa.com
 * Created by peter on 24.05.20.
 */
class CBlockCommentMatcherTest {
    @Test
    void itShouldMatchAnEmptyComment() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/**/");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldNotMatchSomeOtherStringWithoutComment() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("class");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertFalse(groupFound);
    }

    @Test
    @DisplayName("it should match a comment with a one character content 'a'")
    void itShouldMatchACommentWithAOneCharacterContentA() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/*a*/");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldMatchOtherCharacterContentsThanA() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/*b*/");

        // act
        boolean groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldMatchMoreThanOneCharacterContent() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/*Some*/");

        // act and assert
        assertTrue(matcher.find());
    }

    @Test
    void itShouldMatchWhitespaceCharacterContent() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/* Some Text here */");

        // act and assert
        assertTrue(matcher.find());
    }

    @Test
    void itShouldMatchACommentWithAnAsterisk() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/* Some * Comment */");

        // act and assert
        assertTrue(matcher.find());
    }

    @Test
    void itShouldMatchACommentWithASlash() {
        // arrange
        Matcher matcher = CBlockCommentMatcher.getCommentMatcherFor("/* Some / Comment */");

        // act and assert
        assertTrue(matcher.find());
    }
}
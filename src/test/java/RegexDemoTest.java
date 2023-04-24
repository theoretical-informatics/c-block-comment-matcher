import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright 2020 by Bajupa.com
 * Created by peter on 24.05.20.
 */
class RegexDemoTest {
    @Test
    void itShouldMatchAnEmptyComment() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/**/");

        // act
        var groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldNotMatchSomeOtherStringWithoutComment() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("class");

        // act
        var groupFound = matcher.find();

        // assert
        assertFalse(groupFound);
    }

    @Test
    @DisplayName("it should match a comment with a one character content 'a'")
    void itShouldMatchACommentWithAOneCharacterContentA() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/*a*/");

        // act
        var groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldMatchOtherCharacterContentsThanA() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/*b*/");

        // act
        var groupFound = matcher.find();

        // assert
        assertTrue(groupFound);
    }

    @Test
    void itShouldMatchMoreThanOneCharacterContent() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/*Some*/");

        // act and assert
        assertTrue(matcher.find());
    }

    @Test
    void itShouldMatchWhitespaceCharacterContent() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/* Some Text here */");

        // act and assert
        assertTrue(matcher.find());
    }

    @Test
    void itShouldMatchACommentWithAnAsterisk() {
        // arrange
        var matcher = RegexDemo.getCommentMatcherFor("/* Some * Comment */");

        // act and assert
        assertTrue(matcher.find());
    }
}
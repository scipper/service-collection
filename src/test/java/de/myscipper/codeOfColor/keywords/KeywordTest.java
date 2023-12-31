package de.myscipper.codeOfColor.keywords;

import de.myscipper.codeOfColor.CodeOfColor;
import de.myscipper.codeOfColor.PatternColorizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class KeywordTest {

    private CodeOfColor codeOfColor;

    @BeforeEach
    void setUp() {
        PatternColorizer keywordColorizer = new PatternColorizer(new DefaultKeywordPattern(), new DefaultKeywordTags());
        codeOfColor = new CodeOfColor(keywordColorizer);
    }

    @Test
    public void should_surround_a_keyword() {
        String colorizedCode = codeOfColor.colorize("normal text with keyword inside");

        assertEquals("normal text with (kw)keyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_surround_another_keyword() {
        String colorizedCode = codeOfColor.colorize("normal text with anotherkeyword inside");

        assertEquals("normal text with (kw)anotherkeyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_surround_two_keywords() {
        String colorizedCode = codeOfColor.colorize("normal text with a keyword and a anotherkeyword inside");

        assertEquals("normal text with a (kw)keyword(/kw) and a (kw)anotherkeyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_use_different_tags_to_surround_keyword() {
        PatternColorizer keywordColorizer = new PatternColorizer(new DefaultKeywordPattern(), new DifferentKeywordTags());
        codeOfColor = new CodeOfColor(keywordColorizer);

        String colorizedCode = codeOfColor.colorize("normal text with keyword inside");

        assertEquals("normal text with <kw>keyword</kw> inside", colorizedCode);
    }

}

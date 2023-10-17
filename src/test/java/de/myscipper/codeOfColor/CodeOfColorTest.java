package de.myscipper.codeOfColor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CodeOfColorTest {

    private CodeOfColor codeOfColor;
    private StringColorizer stringColorizer;
    private KeywordColorizer keywordColorizer;

    @BeforeEach
    void setUp() {
        stringColorizer = new StringColorizer(new StringTags());
        keywordColorizer = new KeywordColorizer(new MockKeywords(), new KeywordTags());
        codeOfColor = new CodeOfColor(stringColorizer, keywordColorizer);
    }

    @Test
    public void should_return_normal_string_from_input() {
        String colorizedCode = codeOfColor.colorize("normal text");

        assertEquals("normal text", colorizedCode);
    }

    @Test
    public void should_surround_a_keyword() {
        String colorizedCode = codeOfColor.colorize("normal text with keyword inside");

        assertEquals("normal text with (kw)keyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_surround_another_keyword() {
        String colorizedCode = codeOfColor.colorize("normal text with another-keyword inside");

        assertEquals("normal text with (kw)another-keyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_surround_two_keywords() {
        String colorizedCode = codeOfColor.colorize("normal text with a keyword and a another-keyword inside");

        assertEquals("normal text with a (kw)keyword(/kw) and a (kw)another-keyword(/kw) inside", colorizedCode);
    }

    @Test
    public void should_surround_double_quoted_string() {
        String colorizedCode = codeOfColor.colorize("normal text with \"string\" inside");

        assertEquals("normal text with (string)\"string\"(/string) inside", colorizedCode);
    }

    @Test
    public void should_surround_single_quoted_string() {
        String colorizedCode = codeOfColor.colorize("normal text with 'string' inside");

        assertEquals("normal text with (string)'string'(/string) inside", colorizedCode);
    }

    @Test
    public void should_surround_two_strings() {
        String colorizedCode = codeOfColor.colorize("normal text with \"string\" and \"another string\" inside");

        assertEquals("normal text with (string)\"string\"(/string) and (string)\"another string\"(/string) inside", colorizedCode);
    }

    @Test
    public void should_use_different_tags_to_surround_string() {
        StringColorizer stringColorizer = new StringColorizer(new DifferentStringTags());
        codeOfColor = new CodeOfColor(stringColorizer, keywordColorizer);

        String colorizedCode = codeOfColor.colorize("normal text with 'string' inside");

        assertEquals("normal text with <string>'string'</string> inside", colorizedCode);
    }

    @Test
    public void should_use_different_tags_to_surround_keyword() {
        KeywordColorizer keywordColorizer = new KeywordColorizer(new MockKeywords(), new DifferentKeywordTags());
        codeOfColor = new CodeOfColor(stringColorizer, keywordColorizer);

        String colorizedCode = codeOfColor.colorize("normal text with keyword inside");

        assertEquals("normal text with <kw>keyword</kw> inside", colorizedCode);
    }

}

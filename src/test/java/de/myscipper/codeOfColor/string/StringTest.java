package de.myscipper.codeOfColor.string;

import de.myscipper.codeOfColor.CodeOfColor;
import de.myscipper.codeOfColor.PatternColorizer;
import de.myscipper.codeOfColor.pattern.StringPattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringTest {

    private CodeOfColor codeOfColor;

    @BeforeEach
    void setUp() {
        PatternColorizer patternColorizer = new PatternColorizer(new StringPattern(), new DefaultStringTags());
        codeOfColor = new CodeOfColor(patternColorizer);
    }

    @Test
    public void should_return_normal_string_from_input() {
        String colorizedCode = codeOfColor.colorize("normal text");

        assertEquals("normal text", colorizedCode);
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
        PatternColorizer patternColorizer = new PatternColorizer(new StringPattern(), new DifferentStringTags());
        codeOfColor = new CodeOfColor(patternColorizer);

        String colorizedCode = codeOfColor.colorize("normal text with 'string' inside");

        assertEquals("normal text with <string>'string'</string> inside", colorizedCode);
    }

}

package de.myscipper.codeOfColor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CodeOfColorTest {

    private CodeOfColor codeOfColor;

    @BeforeEach
    void setUp() {
        codeOfColor = new CodeOfColor();
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

}

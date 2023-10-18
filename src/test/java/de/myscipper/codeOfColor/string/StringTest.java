package de.myscipper.codeOfColor.string;

import de.myscipper.codeOfColor.CodeOfColor;
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
        StringColorizer stringColorizer = new StringColorizer(new DefaultStringTags());
        codeOfColor = new CodeOfColor(stringColorizer);
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
        StringColorizer stringColorizer = new StringColorizer(new DifferentStringTags());
        codeOfColor = new CodeOfColor(stringColorizer);

        String colorizedCode = codeOfColor.colorize("normal text with 'string' inside");

        assertEquals("normal text with <string>'string'</string> inside", colorizedCode);
    }

}

package de.myscipper.codeOfColor.markup;

import de.myscipper.codeOfColor.CodeOfColor;
import de.myscipper.codeOfColor.PatternColorizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MarkupTest {

    private CodeOfColor codeOfColor;

    @BeforeEach
    void setUp() {
        codeOfColor = new CodeOfColor(new PatternColorizer(new DefaultPattern(), new DefaultMarkupTags()));
    }

    @Test
    public void should_surround_markup_tag() {
        String colorizedCode = codeOfColor.colorize("here is <h1>marked up</h1> text");

        assertEquals("here is (mu)<h1>(/mu)marked up(mu)</h1>(/mu) text", colorizedCode);
    }

    @Test
    public void should_surround_escaped_markup() {
        codeOfColor = new CodeOfColor(new PatternColorizer(new EscapePattern(), new DefaultMarkupTags()));

        String colorizedCode = codeOfColor.colorize("here is &lt;h1&gt;marked up&lt;/h1&gt; text");

        assertEquals("here is (mu)&lt;h1&gt;(/mu)marked up(mu)&lt;/h1&gt;(/mu) text", colorizedCode);
    }

    @Test
    public void should_surround_with_different_tags() {
        codeOfColor = new CodeOfColor(new PatternColorizer(new DefaultPattern(), new DifferentMarkupTags()));

        String colorizedCode = codeOfColor.colorize("here is <h1>marked up</h1> text");

        assertEquals("here is <mu><h1></mu>marked up<mu></h1></mu> text", colorizedCode);
    }

}

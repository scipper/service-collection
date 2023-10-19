package de.myscipper.codeOfColor;

import de.myscipper.codeOfColor.keywords.DefaultKeywordTags;
import de.myscipper.codeOfColor.keywords.DefaultKeywords;
import de.myscipper.codeOfColor.keywords.KeywordColorizer;
import de.myscipper.codeOfColor.markup.DefaultMarkupTags;
import de.myscipper.codeOfColor.markup.DefaultPattern;
import de.myscipper.codeOfColor.pattern.StringPattern;
import de.myscipper.codeOfColor.string.DefaultStringTags;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CompleteTest {

    private CodeOfColor codeOfColor;

    @BeforeEach
    void setUp() {
        PatternColorizer markupColorizer = new PatternColorizer(new DefaultPattern(), new DefaultMarkupTags());
        PatternColorizer patternColorizer = new PatternColorizer(new StringPattern(), new DefaultStringTags());
        KeywordColorizer keywordColorizer = new KeywordColorizer(new DefaultKeywords(), new DefaultKeywordTags());
        codeOfColor = new CodeOfColor(keywordColorizer, patternColorizer, markupColorizer);
    }

    @Test
    public void should_surround_all() {
        String input = "here is <h1>marked up</h1> text. There is also a keyword. \"This text contains anotherkeyword\"";

        String colorizedCode = codeOfColor.colorize(input);

        assertEquals("here is (mu)<h1>(/mu)marked up(mu)</h1>(/mu) text. There is also a (kw)keyword(/kw). (string)\"This text contains (kw)anotherkeyword(/kw)\"(/string)", colorizedCode);
    }

}

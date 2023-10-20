package de.myscipper.codeOfColor.keywords;

import de.myscipper.codeOfColor.Pattern;

public class DefaultKeywordPattern implements Pattern {

    private final String pattern;

    public DefaultKeywordPattern() {
        String[] keywords = {"keyword", "anotherkeyword"};
        pattern = "\\b(" + String.join("|", keywords) + ")\\b";
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}

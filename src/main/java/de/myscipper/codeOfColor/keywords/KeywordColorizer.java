package de.myscipper.codeOfColor.keywords;

import de.myscipper.codeOfColor.Colorizer;
import de.myscipper.codeOfColor.Tags;

import java.util.regex.Pattern;

public class KeywordColorizer implements Colorizer {
    private final Keywords keywords;
    private final Tags tags;

    public KeywordColorizer(Keywords keywords, Tags tags) {
        this.keywords = keywords;
        this.tags = tags;
    }

    @Override
    public String surround(String input) {
        String output = input;
        for (String keyword : keywords.getKeywords()) {
            String regex = "\\b(" + keyword + ")\\b";
            if (Pattern.compile(regex).matcher(input).find()) {
                output = output.replaceAll(regex, tags.getOpening() + "$1" + tags.getClosing());
            }
        }
        return output;
    }

}
package de.myscipper.codeOfColor;

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
            String wrappedKeyword = " " + keyword + " ";
            if (input.contains(wrappedKeyword)) {
                output = output.replace(wrappedKeyword, " " + tags.getOpening() + keyword + tags.getClosing() + " ");
            }
        }
        return output;
    }

}
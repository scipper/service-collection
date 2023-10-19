package de.myscipper.codeOfColor;

public class PatternColorizer implements Colorizer {

    private final Pattern pattern;
    private final Tags tags;

    public PatternColorizer(Pattern pattern, Tags tags) {
        this.pattern = pattern;
        this.tags = tags;
    }

    @Override
    public String surround(String input) {
        return input.replaceAll(pattern.getPattern(), tags.getOpening() + "$1" + tags.getClosing());
    }

}

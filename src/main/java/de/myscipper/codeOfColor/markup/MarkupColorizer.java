package de.myscipper.codeOfColor.markup;

import de.myscipper.codeOfColor.Colorizer;
import de.myscipper.codeOfColor.Tags;

public class MarkupColorizer implements Colorizer {
    private final Tags tags;
    private final Pattern pattern;

    public MarkupColorizer(Tags tags, Pattern pattern) {
        this.tags = tags;
        this.pattern = pattern;
    }

    @Override
    public String surround(String input) {
        return input.replaceAll(pattern.getPattern(), tags.getOpening() + "$1" + tags.getClosing());
    }
}

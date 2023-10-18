package de.myscipper.codeOfColor.markup;

public class DefaultPattern implements Pattern {
    @Override
    public String getPattern() {
        return "(<.*?>)";
    }
}

package de.myscipper.codeOfColor.markup;

public class EscapePattern implements Pattern {
    @Override
    public String getPattern() {
        return "(&lt;.*?&gt;)";
    }
}

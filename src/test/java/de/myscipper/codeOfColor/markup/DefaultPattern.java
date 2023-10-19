package de.myscipper.codeOfColor.markup;

import de.myscipper.codeOfColor.Pattern;

public class DefaultPattern implements Pattern {
    @Override
    public String getPattern() {
        return "(<.*?>)";
    }
}

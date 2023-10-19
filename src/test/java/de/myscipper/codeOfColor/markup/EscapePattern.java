package de.myscipper.codeOfColor.markup;

import de.myscipper.codeOfColor.Pattern;

public class EscapePattern implements Pattern {
    @Override
    public String getPattern() {
        return "(&lt;.*?&gt;)";
    }
}

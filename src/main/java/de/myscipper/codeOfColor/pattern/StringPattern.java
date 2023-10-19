package de.myscipper.codeOfColor.pattern;


import de.myscipper.codeOfColor.Pattern;

public class StringPattern implements Pattern {
    @Override
    public String getPattern() {
        return "('.*?'|\".*?\")";
    }
}

package de.myscipper.codeOfColor;

public class DifferentKeywordTags implements KeywordTags {
    @Override
    public String getOpening() {
        return "<kw>";
    }

    @Override
    public String getClosing() {
        return "</kw>";
    }
}

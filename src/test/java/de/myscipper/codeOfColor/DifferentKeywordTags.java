package de.myscipper.codeOfColor;

public class DifferentKeywordTags implements Tags {
    @Override
    public String getOpening() {
        return "<kw>";
    }

    @Override
    public String getClosing() {
        return "</kw>";
    }
}

package de.myscipper.codeOfColor.keywords;

import de.myscipper.codeOfColor.Tags;

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

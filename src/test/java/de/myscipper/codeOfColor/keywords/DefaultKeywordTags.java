package de.myscipper.codeOfColor.keywords;

import de.myscipper.codeOfColor.Tags;

public class DefaultKeywordTags implements Tags {

    public String getOpening() {
        return "(kw)";
    }

    public String getClosing() {
        return "(/kw)";
    }

}
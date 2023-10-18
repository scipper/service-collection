package de.myscipper.codeOfColor.string;

import de.myscipper.codeOfColor.Tags;

public class DefaultStringTags implements Tags {
    @Override
    public String getOpening() {
        return "(string)";
    }

    @Override
    public String getClosing() {
        return "(/string)";
    }
}

package de.myscipper.codeOfColor.markup;

import de.myscipper.codeOfColor.Tags;

public class DifferentMarkupTags implements Tags {
    @Override
    public String getOpening() {
        return "<mu>";
    }

    @Override
    public String getClosing() {
        return "</mu>";
    }
}

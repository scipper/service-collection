package de.myscipper.codeOfColor;

public class DifferentStringTags implements Tags {
    @Override
    public String getOpening() {
        return "<string>";
    }

    @Override
    public String getClosing() {
        return "</string>";
    }
}

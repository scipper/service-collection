package de.myscipper.codeOfColor;

public class MockKeywordTags implements KeywordTags {

    public String getOpening() {
        return "(kw)";
    }

    public String getClosing() {
        return "(/kw)";
    }

}
package de.myscipper.codeOfColor;

import java.util.ArrayList;
import java.util.List;

public class MockKeywords implements Keywords {

    private final List<String> keywords;
    private final String opening;
    private final String closing;

    public MockKeywords() {
        keywords = new ArrayList<>();
        keywords.add("keyword");
        keywords.add("another-keyword");
        opening = "(kw)";
        closing = "(/kw)";
    }

    @Override
    public List<String> getKeywords() {
        return this.keywords;
    }

    @Override
    public String getOpening() {
        return this.opening;
    }

    @Override
    public String getClosing() {
        return this.closing;
    }

}

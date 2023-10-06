package de.myscipper.codeOfColor;

import java.util.ArrayList;
import java.util.List;

public class MockKeywords implements Keywords {

    private final List<String> keywords;

    public MockKeywords() {
        keywords = new ArrayList<>();
        keywords.add("keyword");
        keywords.add("another-keyword");
    }

    @Override
    public List<String> getKeywords() {
        return this.keywords;
    }

}

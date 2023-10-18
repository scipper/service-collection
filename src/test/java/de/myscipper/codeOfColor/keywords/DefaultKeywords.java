package de.myscipper.codeOfColor.keywords;

import java.util.ArrayList;
import java.util.List;

public class DefaultKeywords implements Keywords {

    private final List<String> keywords;

    public DefaultKeywords() {
        keywords = new ArrayList<>();
        keywords.add("keyword");
        keywords.add("anotherkeyword");
    }

    @Override
    public List<String> getKeywords() {
        return this.keywords;
    }

}

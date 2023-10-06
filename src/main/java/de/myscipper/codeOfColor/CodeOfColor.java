package de.myscipper.codeOfColor;

public class CodeOfColor {

    private final Keywords keywords;
    private final KeywordTags keywordTags;

    public CodeOfColor(Keywords keywords, KeywordTags keywordTags) {
        this.keywords = keywords;
        this.keywordTags = keywordTags;
    }

    private String surroundString(String input, String quotes) {
        String output;
        int openingString = input.indexOf(quotes);
        int closingString = input.indexOf(quotes, openingString + 1);
        output = input.substring(0, openingString);
        String openStringTag = "(string)";
        String closeStringTag = "(/string)";
        output += openStringTag;
        output += input.substring(openingString, closingString + 1);
        output += closeStringTag;
        output += input.substring(closingString + 1);
        System.out.println(output);
        return output;
    }

    public String colorize(String input) {
        String output = input;
        for (String keyword : keywords.getKeywords()) {
            String wrappedKeyword = " " + keyword + " ";
            if (input.contains(wrappedKeyword)) {
                output = output.replace(wrappedKeyword, " " + keywordTags.getOpening() + keyword + keywordTags.getClosing() + " ");
            }
        }
        String doubleQuote = "\"";
        String singleQuote = "'";
        if (input.contains(doubleQuote)) {
            output = surroundString(input, doubleQuote);
        }
        if (input.contains(singleQuote)) {
            output = surroundString(input, singleQuote);
        }
        return output;
    }
}

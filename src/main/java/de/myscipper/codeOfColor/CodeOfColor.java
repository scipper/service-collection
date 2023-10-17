package de.myscipper.codeOfColor;

public class CodeOfColor {

    private final Keywords keywords;
    private final Tags tags;
    private final Tags stringTags;

    public CodeOfColor(Keywords keywords, Tags tags, Tags stringTags) {
        this.keywords = keywords;
        this.tags = tags;
        this.stringTags = stringTags;
    }

    public String colorize(String input) {
        String output = input;

        output = surroundStrings(output);
        output = surroundKeywords(output);

        return output;
    }

    private String surroundKeywords(String input) {
        String output = input;
        for (String keyword : keywords.getKeywords()) {
            String wrappedKeyword = " " + keyword + " ";
            if (input.contains(wrappedKeyword)) {
                output = output.replace(wrappedKeyword, " " + tags.getOpening() + keyword + tags.getClosing() + " ");
            }
        }
        return output;
    }

    private String surroundStrings(String input) {
        String output = input;
        String doubleQuote = "\"";
        String singleQuote = "'";
        if (input.contains(doubleQuote)) {
            output = replaceQuotes(input, doubleQuote);
        }
        if (input.contains(singleQuote)) {
            output = replaceQuotes(input, singleQuote);
        }
        return output;
    }

    private String replaceQuotes(String input, String quotes) {
        int openingString = input.indexOf(quotes);
        int closingString = input.indexOf(quotes, openingString + 1);

        if (openingString == -1 || closingString == -1) {
            return input;
        }

        String output = input.substring(0, openingString);
        output += stringTags.getOpening();
        output += input.substring(openingString, closingString + 1);
        output += stringTags.getClosing();

        output += replaceQuotes(input.substring(closingString + 1), quotes);

        return output;
    }
}

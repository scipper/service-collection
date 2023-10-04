package de.myscipper.codeOfColor;

public class CodeOfColor {
    private static String surroundString(String input, String doubleQuote) {
        String output;
        int openingString = input.indexOf(doubleQuote);
        int closingString = input.indexOf(doubleQuote, openingString + 1);
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
        if (input.contains("keyword")) {
            output = input.replace("keyword", "(kw)keyword(/kw)");
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

package de.myscipper.codeOfColor;

public class StringColorizer implements Colorizer {
    private final Tags tags;

    public StringColorizer(Tags tags) {
        this.tags = tags;
    }

    @Override
    public String surround(String input) {
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
        output += tags.getOpening();
        output += input.substring(openingString, closingString + 1);
        output += tags.getClosing();

        output += replaceQuotes(input.substring(closingString + 1), quotes);

        return output;
    }
}
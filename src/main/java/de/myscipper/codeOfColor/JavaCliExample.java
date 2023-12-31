package de.myscipper.codeOfColor;

import de.myscipper.codeOfColor.pattern.HtmlPattern;
import de.myscipper.codeOfColor.pattern.StringPattern;


public class JavaCliExample {

    public static void main(String[] args) {
        PatternColorizer stringColorizer = new PatternColorizer(new StringPattern(), new JavaCliStringTags());
        PatternColorizer keywordColorizer = new PatternColorizer(new JavaCliKeywordPattern(), new JavaCliKeywordTags());
        PatternColorizer markupColorizer = new PatternColorizer(new HtmlPattern(), new MarkupTags());

        CodeOfColor codeOfColor = new CodeOfColor(stringColorizer, keywordColorizer, markupColorizer);

        for (String arg : args) {
            String colorized = codeOfColor.colorize(arg);
            System.out.println(colorized);
        }
    }

    private static class JavaCliStringTags implements Tags {

        @Override
        public String getOpening() {
            return AnsiColors.ANSI_CYAN;
        }

        @Override
        public String getClosing() {
            return AnsiColors.ANSI_RESET;
        }
    }

    private static class AnsiColors {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
    }

    private static class JavaCliKeywordPattern implements Pattern {
        private final String pattern;

        public JavaCliKeywordPattern() {
            String[] keywords = {"public", "void"};
            pattern = "\\b(" + String.join("|", keywords) + ")\\b";
        }

        @Override
        public String getPattern() {
            return pattern;
        }
    }

    private static class JavaCliKeywordTags implements Tags {
        @Override
        public String getOpening() {
            return AnsiColors.ANSI_PURPLE;
        }

        @Override
        public String getClosing() {
            return AnsiColors.ANSI_RESET;
        }
    }

    private static class MarkupTags implements Tags {
        @Override
        public String getOpening() {
            return AnsiColors.ANSI_YELLOW;
        }

        @Override
        public String getClosing() {
            return AnsiColors.ANSI_RESET;
        }
    }

}

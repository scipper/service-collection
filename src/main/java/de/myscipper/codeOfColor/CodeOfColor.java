package de.myscipper.codeOfColor;

public class CodeOfColor {

    private final Colorizer[] colorizers;

    public CodeOfColor(Colorizer... colorizers) {
        this.colorizers = colorizers;
    }

    public String colorize(String input) {
        String output = input;

        for (Colorizer colorizer : colorizers) {
            output = colorizer.surround(output);
        }

        return output;
    }

}

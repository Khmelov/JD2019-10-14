package by.it.toporova.calculator_jd02_05_and_jd02_06;

class Patterns {

    private static final String VARIABLE = "-?[A-z]+[0-9]?";
    static final String SCALAR = "(-?([0-9]+)(\\.[0-9]+)*)";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "(?<=[^-+*/={,( ])[-+*/=]";
    static final String CALCULATION = "(?<=[^-+*/={, ])[-+*/]";
    static final String PRIOR_OPERATION
            = "\\((" + VARIABLE + "|" + SCALAR + "|" + VECTOR + "|" + MATRIX + ")"
            + OPERATION
            + "(" + VARIABLE + "|" + SCALAR + "|" + VECTOR + "|" + MATRIX + ")\\)";
}
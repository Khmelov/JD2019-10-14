package by.it.yurtsevich.jd02_05.calc;

class Patterns {

    static final String OPERATION = "(?<![-*/+={,])[-+*/=]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+\\}";
    static final String MATRIX = "\\{((\\{((-?[0-9]+\\.?[0-9]*),?)+\\}),?)+\\}";
    static final String BRACKETS = "\\([-0-9+*/a-zA-Z.{},_ ]+\\)";

}

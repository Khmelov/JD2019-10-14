package by.it.sermyazhko.calc1;

interface PatternForExpression {
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{"+SCALAR+"(, *"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(, *"+VECTOR+")*}";
    String OPERATION = "(?<=[^-+*/={,])[-+*/=]";
}
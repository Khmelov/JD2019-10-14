package by.it.sermyazhko.calc1;

interface PatternForExpression {
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{(-?[0-9]+(\\\\.[0-9]+)?,?)+}";
    String MATRIX = "\\{(\\{(-?[0-9]+(\\.[0-9]+)?,?)+},?)+}";
    //String OPERATION="[-+*/=]";
    String OPERATION = "(?<=[^-+*/={,])[-+*/=]";
}
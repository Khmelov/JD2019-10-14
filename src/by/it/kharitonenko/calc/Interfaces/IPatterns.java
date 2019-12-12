package by.it.kharitonenko.calc.Interfaces;

public interface IPatterns {
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX="\\{((\\{((-?[0-9]+\\.?[0-9]*),?)+\\}),?)+}";
    String OPERATION="(?<=[^-+*/={,])[-+*/=]";
    String BRACKETS = "\\([-0-9+*/a-zA-Z.{},_ ]+\\)";
}

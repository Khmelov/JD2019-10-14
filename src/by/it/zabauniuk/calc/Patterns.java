package by.it.zabauniuk.calc;

class Patterns {

    static final String OPERATION = "[-+*/=]";
    static final String SCALAR = "-?[0-9]+(\\.?[0-9]+)?";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

}
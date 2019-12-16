package by.it.protsko.calc;

interface Patterns {

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(,[\\s]?" + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(,[\\s]?" + VECTOR + ")*}";
    String OPERATIONS = "(?<=[^-+*/={,])[-+*/=]";
}

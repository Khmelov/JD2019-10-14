package by.it.kazak.calc;

interface Patterns {
    String BRAKETS = "[(]([A-Za-z]|(-?\\d+(\\.\\d+)?))([-+*/=])([A-Za-z]|(-?\\d+(\\.\\d+)?))?[)]";
    String OPERATION = "(?<=[^-+*=/,{])([-+*/=])";
    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "[{]((-?\\d+(\\.\\d+)?),?\\s?)+[}]";
    String MATRIX = "[{]([{]((-?\\d+(\\.\\d+)?),?\\s?)+[}],?\\s?)+[}]";
}

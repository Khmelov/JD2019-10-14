package by.it.komarov.jd01_10;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

class GetType {
    static String getModyfierType(int typeDigit) {
        StringBuilder modifierType = new StringBuilder();
        if (Modifier.isPublic(typeDigit))   modifierType.append("public ");
        if (Modifier.isPrivate(typeDigit))  modifierType.append("private ");
        if (Modifier.isAbstract(typeDigit)) modifierType.append("abstract ");
        if (Modifier.isStatic(typeDigit))   modifierType.append("static ");
        if (Modifier.isFinal(typeDigit))    modifierType.append("final ");
        return modifierType.toString();
    }

    static String getParametersType(Parameter[] parameters) {
        StringBuilder parametersType = new StringBuilder();
        int count = 0;
        for (Parameter parameter : parameters) {
            count++;
            if (count > 1) {
                parametersType.append(",").append(parameter.getType());
            } else {
                parametersType.append(parameter.getType());
            }
        }
        return parametersType.toString();
    }
}

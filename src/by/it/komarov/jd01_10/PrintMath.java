package by.it.komarov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClassStructure = Math.class;
        Field[] fields = mathClassStructure.getDeclaredFields();
        Method[] methods = mathClassStructure.getDeclaredMethods();

        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.println(GetType.getModyfierType(field.getModifiers()) + field.getType() + " " + field.getName());
            }
        }

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println(GetType.getModyfierType(method.getModifiers())
                        + method.getReturnType() + " "
                        + method.getName() + "("
                        + GetType.getParametersType(method.getParameters()) + ")");
            }
        }
    }
}
package by.it.volchek.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structure = Math.class;
        for( Method method : structure.getDeclaredMethods()){
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder sb = new StringBuilder("public");
                sb.append(method.getName()).append("(");
                System.out.println(method);
            }
        }
    }
}

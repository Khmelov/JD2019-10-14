package by.it.sermyazhko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    public static void main(String[] args) {
        Class<String> structure = String.class;
        for (Method declaredMethod : structure.getDeclaredMethods()) {
            int mod = declaredMethod.getModifiers();
            if(!Modifier.isStatic(mod)){
                System.out.println(declaredMethod.getName());
            }
        }
    }
}

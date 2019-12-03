package by.it.zabauniuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : structMath.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder sb = new StringBuilder("public ");
                if (Modifier.isStatic(modifiers)){
                    sb.append("static ");
                }
                sb.append(method.getReturnType()).append(" ").append(method.getName()).append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    sb.append(parameterTypes[i]);
                    if (i != parameterTypes.length - 1)
                        sb.append(',');
                }
                sb.append(")");
                System.out.println(sb);
            }
        }
        Field[] fields = Math.class.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(field.getType());
                    stringBuilder.append(' ');
                    String fieldName = field.getName();
                    stringBuilder.append(fieldName);
                    System.out.println(stringBuilder);
                }
            }
        }
    }

}

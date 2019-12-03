package by.it.sermyazhko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Class<Math> structure = Math.class;
        //structure.getDeclaredMethod()
        for (Method method : structure.getDeclaredMethods()) {
            int modifier = method.getModifiers();
            /*if ((modifier&1)==1){
                System.out.println(method);
            }*/
            if (Modifier.isPublic(modifier)) {
                sb.append("public ");
                if (Modifier.isStatic(modifier)) {
                    sb.append("static ").append(method.getReturnType()).append(" ");
                    sb.append(method.getName()).append("(");
                }
                int parameterCount = method.getParameterCount();
                if (parameterCount == 0) {
                    sb.append(")");
                } else {
                    for (int i = 0; i < method.getParameterTypes().length; i++) {
                        sb.append(method.getParameterTypes()[i]);

                        if (i == method.getParameterTypes().length - 1) {
                            sb.append(")\n");
                        } else {
                            sb.append(",");
                        }
                    }
                }
            }
        }
            //field

            for (Field field : structure.getDeclaredFields()) {
                int modif = field.getModifiers();
            /*if ((modifier&1)==1){
                System.out.println(method);
            }*/
                if (Modifier.isPublic(modif)) {
                    sb.append("public ");
                    if (Modifier.isStatic(modif)) {
                        sb.append("static ");
                    }
                    sb.append(field.getType()).append(" ");
                    sb.append(field.getName());
                    sb.append("\n");

                }


            }
            System.out.println(sb);
     }
}




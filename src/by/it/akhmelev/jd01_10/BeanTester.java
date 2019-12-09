package by.it.akhmelev.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception{

        Class<Bean> structure = Bean.class;
        Bean bean = structure.newInstance();
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                Object result = method.invoke(bean, annotation.a(), annotation.b());
                System.out.println(method.getName()+" "+result);
            }
        }

    }
}

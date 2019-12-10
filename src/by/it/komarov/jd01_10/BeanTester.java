package by.it.komarov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Object object = null;
        Class<Bean> beanClassStructure = Bean.class;
        Method[] beanClassMethods = beanClassStructure.getDeclaredMethods();

        for (Method beanClassMethod : beanClassMethods) {
            if (beanClassMethod.isAnnotationPresent(Param.class)) {
                Param classAnnotation = beanClassMethod.getDeclaredAnnotation(Param.class);
                if (object == null) {
                    object = beanClassStructure.newInstance();
                }

                System.out.println("@" + classAnnotation.annotationType().getSimpleName());
                System.out.println(GetType.getModyfierType(beanClassMethod.getModifiers())
                        + beanClassMethod.getReturnType()
                        + " "
                        + beanClassMethod.getName()
                        + "("
                        + GetType.getParametersType(beanClassMethod.getParameters())
                        + ") :" + beanClassMethod.invoke(object, classAnnotation.a(), classAnnotation.b()));
            }
        }
    }
}
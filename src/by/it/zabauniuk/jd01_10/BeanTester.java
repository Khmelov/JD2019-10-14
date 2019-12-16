package by.it.zabauniuk.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor beanConstr = beanClass.getConstructor();
        Bean testBean = (Bean) beanConstr.newInstance();
        Method[] beanMethods = Bean.class.getDeclaredMethods();
        for (Method beanMethod : beanMethods) {
            if (beanMethod.isAnnotationPresent(Param.class)) {
                Param anno = beanMethod.getAnnotation(Param.class);
                beanMethod.invoke(testBean, anno.a(), anno.b());
                System.out.println("Имя метода " + beanMethod.getName() + " " +
                        beanMethod.invoke(testBean, anno.a(), anno.b()));
            }
        }
    }
}

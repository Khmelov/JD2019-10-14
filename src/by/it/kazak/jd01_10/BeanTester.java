package by.it.kazak.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;


public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] bean = beanClass.getDeclaredMethods();
        for (Method method : bean) {

            System.out.println(method);
        }
    }
}

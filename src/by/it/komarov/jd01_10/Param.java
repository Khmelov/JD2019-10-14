package by.it.komarov.jd01_10;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Аннотация может применятся над методами
@Retention(RetentionPolicy.RUNTIME) // Применяется в момен работы анотации
public @interface Param {
    int a(); // можно установить значение по умолчанию int a() defaul 100;
    int b();
}

package by.it.komarov.jd01_14;

import java.io.*;

public class Helper {
    // функция для определения текущей дериктории в котой находится наш класс
    static String dir(Class<?> cl){
        // определяем где находится каталог проекта
        // File.separator - разделитель вводящий слэши (универсальный под Mac и Windows)
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        // Получаем информацияю из полученного класса
        // get.name() - получаем полный путь к классу
        // get.simpleName - получение только имени класса
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
}

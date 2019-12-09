package by.it.yaroshenko.jd01_14;

/*
 Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt
 */

import java.io.File;

public class TaskC {
    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path1=path+TaskC.class.getPackage().getName();
        System.out.println(path1);
    }
}

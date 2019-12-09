package by.it.volchek.jd01_15;

import java.io.*;
import java.util.Random;

/*
Создайтематрицу6строкна4столбцаизцелыхслучайныхчиселот-15до15включительно.
 Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
 При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.

 */
public class TaskA {
    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator).
                replace("jd01_15\\", "");
    }
    public static void main(String[] args) {
        int [][] array = new int [6][4];
        Random random = new Random();
        random.nextInt(16);
        random.nextBoolean();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                int temp=random.nextInt(16);
                if (random.nextBoolean()) temp*=-1;
                array [i][j] = temp;
            }
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(dir(TaskA.class)+"matrix.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(dir(TaskA.class)+"matrix.txt"))) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    writer.printf("%3d ",array [i][j]);
                }
                writer.println();
            }
            writer.close();
            while (reader.ready())
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

package by.it.toporova.jd01_15;

import java.io.*;

//Класс TaskA
//Создайте матрицу 6строк на 4 столбца из
// целых случайных чисел от -15 до 15 включительно.
//Выведите матрицу в текстовый файл matrix.txt, расположенный в папке заданияjd01_15.
// При выводе для каждого числа нужно предусмотреть для него три знакоместа, после чисел –один пробел.
//Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.
public class TaskA {


   public static void main(String[] args) {
        //инициализируем матрицу
        int[][] array = create(6, 4, 15);
        String filename = createFile(TaskA.class, "matrix.txt");
        saveMatrix(array, filename);
        readFile(filename);


    }

     private static void readFile(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     private static void saveMatrix(int[][] array, String filename) {
        //FileWriter - выходной поток, пишущий  файлы
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     private static String createFile(Class<TaskA> taskAClass, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = taskAClass.getPackage().getName().replace(".", File.separator);
        return (src + replacePath + File.separator + name);
    }


     private static int[][] create(int rows, int columns, int threshold) {
        int[][] array = new int[rows][columns];
        boolean maxOk = false;
        boolean minOk = false;
        int max = 15;
        do {
            for (int i = 0; i < array.length; i++) { //проход по строкам
                for (int j = 0; j < array[i].length; j++) { //проход по колонкам
                    array[i][j] = (int) (Math.random() * 31) - 15; //включая края
                    if (array[i][j] == max) maxOk = true;
                    if (array[i][j] == -max) minOk = true;
                }
            }

        }while (!(maxOk && minOk));
        return array;

    }

}





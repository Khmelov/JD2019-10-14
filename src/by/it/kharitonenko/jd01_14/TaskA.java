package by.it.kharitonenko.jd01_14;

//         Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
//         Файл должен быть в том же каталоге, что и исходный код для класса
//        TaskA.java.
//         Затем нужно прочитать записанный файл в коллекцию ArrayList.
//         Вывести в консоль прочитанные числа через пробел
//         Вывести с новой строки их среднее арифметическое avg=20.123.
//         Продублировать вывод в консоль в файл resultTaskA.txt

import java.io.*;

class TaskA {

    File dataBin = new File("dataTaskA.bin");
    File dataTxt = new File("resultTaskA.txt");

    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(dir(TaskA.class) + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (DataInputStream inp = new DataInputStream(new BufferedInputStream
                (new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter
                     (new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                out2.print(i + " ");
                sum = sum + i;
                count++;
            }
            System.out.print("\navg=" + sum / count);
            out2.print("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
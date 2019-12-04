package by.it.toporova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String filename=path + "dataTaskA.bin";
        writeInteger(filename);
        List<Integer> list = new ArrayList<>();
        readList(filename, list);
        printToConsole(list);
        printToFile(path, list);
    }

    private static void printToFile(String path, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(
                path + "resultTaskA.txt")
        ) {
            double sum2 = 0;
            for (Integer value : list) {
                out.print(value + " ");
                sum2 += value;
            }
            out.println("\navg=" + sum2 / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            System.out.print(value + " ");
            sum += value;
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void readList(String filename, List<Integer> list) {
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename)
                        )
                )
        ) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInteger(String filename) {
        try (
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)
                        )
                )
        ) {
            Random random = new Random(System.nanoTime());
            for (int i = 0; i < 20; i++) {
                dos.writeInt(random.nextInt(1000));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPath(Class<TaskA> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                aClass
                        .getName()
                        .replace(aClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}


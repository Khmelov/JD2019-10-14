package by.it.konovalova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String path = getPath();
        String fileName = path + "dataTaskA.bin";
        writeInteger(fileName);
        readList(fileName, list);
        printToConsole(list);
        printToFile(path, list);
    }

    private static void writeInteger(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readList(String fileName, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer i : list) {
            sum+=i;
            System.out.print(i + " ");
        }
        System.out.println("\navg=" + sum / list.size());
    }

    private static void printToFile(String path, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path + "resultTaskA.txt"))) {
            double sum = 0;
            for (Integer i : list) {
                out.print(i + " ");
                sum += i;
            }
            out.println("\navg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskA.class.getName().
                replace(TaskA.class.getSimpleName(), "").
                replace(".", File.separator);
    }
}


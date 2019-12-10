package by.it.protsko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskA {
    public static void main(String[] args) {

        String path = getPath(TaskA.class);
        String fileName = path + "dataTaskA.bin";
        writeInteger(fileName);
        List<Integer> list = new ArrayList<>();
        list = printFileToList(fileName, list);
        printListToConsole(list);
        writeListToFile(path, list);
    }

    private static void writeListToFile(String path, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(path + "resultTaskA.txt")) {
            int sum2 = 0;
            for (Integer element : list) {
                out.print(element + " ");
                sum2 += element;
            }
            out.print("\navg=" + (double) sum2 / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printListToConsole(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            System.out.print(element + " ");
            sum += element;
        }
        System.out.println("\navg=" + (double) sum / list.size());
    }

    private static List<Integer> printFileToList(String fileName, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            list = new ArrayList<>();
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writeInteger(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 1000));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<TaskA> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + aClass
                .getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}

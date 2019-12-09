package by.it.yaroshenko.jd01_14;
import java.io.*;
import java.util.*;

public class TaskA {

    private static List<Integer> objects = new ArrayList<>();

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        System.out.println(dir());
        output();
        printToFile();
    }

    private static void output() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir() + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) Math.ceil(Math.random() * 20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void printToFile() {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir() + "dataTaskA.bin")))) {
            try (PrintWriter out2 = new PrintWriter(new FileWriter(dir() + "resultTaskA.txt"))) {
                int c;
                while ((c=dis.available()) > 0) {
                    objects.add(dis.readInt());
                }
                int count=0;
                double sum=0;
                for (Integer object : objects) {
                    System.out.print(object+" ");
                    count++;
                    sum+=object;
                }
                System.out.println("\navg=" + (double)sum / count);
//                System.out.println("\navg=" + sum / count);
               out2.print("\navg=" + (double)sum / count);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

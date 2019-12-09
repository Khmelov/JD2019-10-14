package by.it.komarov.jd01_14;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        CreateFile.writeRandomInt();

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                Helper.dir(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out = new PrintWriter(new FileWriter(Helper.dir(TaskA.class)+"resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (dis.available()>0) {
                int i = dis.readInt();
                System.out.print(i+" ");
                out.print(i+" ");
                sum+=i;
                count++;
            }
            System.out.println("\navg="+sum/count);
            out.print("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

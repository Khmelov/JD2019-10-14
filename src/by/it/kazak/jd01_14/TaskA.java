package by.it.kazak.jd01_14;


import java.io.*;


public class TaskA {

    private static String dir() {
        String path = System.getProperty("user.dir")+ File.separator+"src"+ File.separator;
        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    public static void main(String[] args) {
        writeInt();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                dir()+"dataTaskA.bin")));
             PrintWriter out = new PrintWriter(new FileWriter(dir()+"resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (dis.available()>0) {
                int i = dis.readInt();
                System.out.print(i+" ");
                out.print(i+" ");
                sum=sum+i;
                count++;
            }
            System.out.println("\navg="+sum/count);
                out.print("\navg="+sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInt() {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dir()+"dataTaskA.bin")
                )
        )
        ){
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20) +10);
            }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


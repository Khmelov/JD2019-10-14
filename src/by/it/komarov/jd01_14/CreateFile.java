package by.it.komarov.jd01_14;

import java.io.*;

class CreateFile {
    static void writeRandomInt() {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(Helper.dir(TaskA.class)+"dataTaskA.bin")
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

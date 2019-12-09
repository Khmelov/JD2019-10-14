package by.it.komarov.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Read {
    static void readTextFile(String filename, StringBuilder sb){
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))){
            while (br.ready()) {
                sb.append(br.readLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

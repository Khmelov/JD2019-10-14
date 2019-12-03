package by.it.zimina.jd01_15;

import java.io.*;

public class TaskA {
    private static String dir(Class<?> cl){
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    private static String generateMatrix(){
        int matrix[][] = new int[6][4];
        String res = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=(int)(Math.random() * 30 - 15);
                res = res + matrix[i][j] + ", ";
            }
            res=res+"\n";
        }
        return res;
    }

    public static void main(String[] args) {
        BufferedWriter dos=null;
        try {
            dos = new BufferedWriter(
                          new FileWriter(dir(TaskA.class)+"matrix.txt"));


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

package by.it.zimina.jd01_15;

import java.io.*;
import java.util.Arrays;

public class TaskA {

    private static String dir(Class<?> cl){
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    private static int[][] generateMatrix(){
        int matrix[][]= new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=(int)(Math.random() * 30 - 15);
            }
        }
        return matrix;
    }

    private static void writeMatrix(int[][] matrix){
        try {
            PrintWriter printWriter=new PrintWriter(dir(TaskA.class) + "martix.txt");
            for (int[] row : matrix) {
                printWriter.println(Arrays.toString(row)
                        .replace(",","")
                        .replace("[","")
                        .replace("]",""));
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix();
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replace(",","")
                    .replace("[","")
                    .replace("]",""));
        }
        writeMatrix(matrix);

        }




}

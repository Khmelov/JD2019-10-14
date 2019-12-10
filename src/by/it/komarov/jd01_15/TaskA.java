package by.it.komarov.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        String filename = FileName.getFileName("matrix.txt");
        Matrix.saveMatrixToFile(Matrix.createMatrix(), filename);
        Matrix.showMatrix(filename);
        System.out.println();
    }
}
package by.it.komarov.jd02_01;

import java.util.Random;

public class Runner {
    private static Random generator;
    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {
            System.out.println(new Random(System.nanoTime()));

        }



    }
}

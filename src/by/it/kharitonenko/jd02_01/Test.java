package by.it.kharitonenko.jd02_01;

import by.it.kharitonenko.jd02_01.Utils.Goods;

import java.util.Random;

public class Test {
 public static int intRandom(int max) {
        return intRandom(0, max);
    }

    public static int intRandom(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(intRandom(2));
        }
    }
}

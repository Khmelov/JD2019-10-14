package by.it.komarov.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Market {
    private static int countBuyer = 0; // общий счётчик покупаетелей. Возникает проблема обращения к общему ресурсу

    public static void main(String[] args) throws InterruptedException {
        Queue<Buyer> queue = new ArrayDeque<>();
        while (countBuyer < 10){
            Thread.sleep(1000); // ожидание 1 секунду
            for (int i = 0; i < Randomize.fromTo(0,2); i++) {
                countBuyer++;
                if (countBuyer < 11){
                    queue.add(new Buyer(countBuyer));
                }
            }
        }
    }
}

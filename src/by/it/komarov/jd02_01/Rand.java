package by.it.komarov.jd02_01;

import java.util.Random;

    class Rand {
    private static final long init = System.currentTimeMillis();
    private static final Random random = new Random(init);


    static int fromTo(int from, int to){
        int delta = to - from + 1;
        int msWait = from + random.nextInt(delta);
        return msWait;
    }
}

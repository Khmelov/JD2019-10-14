package by.it.komarov.jd02_01;


class Randomize {
    private static final java.util.Random random = new java.util.Random(System.currentTimeMillis());

    static int fromTo(int from, int to){
        return from + random.nextInt(to - from + 1);
    }

    static  void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            System.out.println("Unexpected error");
        }
    }
}

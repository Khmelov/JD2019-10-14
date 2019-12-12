package by.it.komarov.jd02_01;

class Randomize {
    private static final java.util.Random random = new java.util.Random(System.currentTimeMillis());

    static int fromTo(int from, int to){
        return from + random.nextInt(to - from + 1);
    }
}

package by.it.protsko.jd02_02;

class Helper {

    static int randomValue(int from, int to) {
        return (int) ((Math.random() * ((to - from) + 1)) + from);
    }

    static int randomValueForPensioner(int from, int to) {
        return (int) (((Math.random() * ((to - from) + 1)) + from) * Dispather.pensionerSpeedProcess);
    }
}

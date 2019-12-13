package by.it.komarov.jd01_14;

class Count {
    private static int wordsCount = 0;
    private static int marksCount = 0;

    static int getWordscount() {
        return wordsCount;
    }

    static void setWordscount(int wordscount) {
        Count.wordsCount = wordscount;
    }

    static int getMarkscount() {
        return marksCount;
    }

    static void setMarkscount(int markscount) {
        Count.marksCount = markscount;
    }
}

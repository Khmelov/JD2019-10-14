package by.it.komarov.jd01_14;

class TaskB {
    public static void main(String[] args) {
        String path = Get.getPath(TaskB.class);
        String filename = path + "text.txt";
        StringBuilder sb = new StringBuilder();
        Read.readTextFile(filename, sb);
        Get.getCounts(sb);
        Print.printToConole(Count.getWordscount(),Count.getMarkscount());
        Print.printToFile(path,Count.getWordscount(),Count.getMarkscount());
    }
}
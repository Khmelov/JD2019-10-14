package by.it.komarov.jd01_14;

import java.io.File;

class Get {
    static void getCounts(StringBuilder sb){
        String text = new String(sb);
        String[] words = text.split("[\\n,. :\"—;/!-]+");
        String[] marks = text.split("[а-яёА-ЯЁ ]+");
        Count.setWordscount(words.length);
        Count.setMarkscount(marks.length-1);
    }

    static String getPath(Class<TaskB> bClass) {
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator +
                bClass.getName()
                        .replace(bClass.getSimpleName(),"")
                        .replace(".", File.separator);
    }
}

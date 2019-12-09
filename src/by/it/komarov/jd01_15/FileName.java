package by.it.komarov.jd01_15;

import java.io.File;

class FileName {
    static String getFileName(String filename) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskA.class.getPackage().getName().replace(".", File.separator);
        return src + strPackage + File.separator + filename;
    }
}

package by.it.konovalova.jd01_14;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath();
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        printToConsole(file, sb);
        printToFile(path, file, sb);
    }

    private static void printToConsole(File file, StringBuilder sb) {
        if (file.isDirectory()) {
            for (File dir : file.listFiles()) {
                if (dir.isDirectory()) {
                    sb.append("dir:").append(dir.getName()).append("\n");
                    for (File subDir : dir.listFiles()) {
                        sb.append("file:").append(subDir.getName()).append("\n");
                    }
                } else if (dir.isFile()) {
                    sb.append("file:").append(dir.getName()).append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    private static void printToFile(String path, File file, StringBuilder sb) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(path + File.separator + "jd01_14" + File.separator + "resultTaskC.txt"))) {
            if (file.isDirectory()) {
                for (File dir : file.listFiles()) {
                    if (dir.isDirectory()) {
                        sb.append("dir:").append(dir.getName()).append("\n");
                        for (File subDir : dir.listFiles()) {
                            sb.append("file:").append(subDir.getName()).append("\n");
                        }
                    } else if (dir.isFile()) {
                        sb.append("file:").append(dir.getName()).append("\n");
                    }
                }
                out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskC.class.getPackage().getName().
                replace("jd01_14", "").
                replace(".", File.separator);
    }
}

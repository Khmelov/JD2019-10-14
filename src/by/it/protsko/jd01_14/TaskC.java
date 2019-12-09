package by.it.protsko.jd01_14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class TaskC {

    private static List<String> dirList = new ArrayList<>();
    private static List<String> fileList = new ArrayList<>();
    private static final String tasksPath = getPath(TaskC.class).replaceAll("jd01_14", "");


    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        list(tasksPath);
        printResultToConsole();
        printConsoleToFile(path + "resultTaskC.txt", dirList, fileList);
    }

    private static void printResultToConsole() {
        for (String dirElement : dirList) {
            System.out.println("dir:" + dirElement);
        }
        for (String fileElement : fileList) {
            System.out.println("file:" + fileElement);
        }
    }

    private static void printConsoleToFile(String path, List<String> dirList, List<String> fileList) {
        try (PrintWriter out = new PrintWriter(path)) {
            for (String dirElement : dirList) {
                out.println("dir:" + dirElement);
            }
            for (String fileElement : fileList) {
                out.println("file:" + fileElement);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void list(String path) {
        File file = new File(path);
        for (File element : file.listFiles()) {
            if (element.isDirectory()) {
                dirList.add(element.getName());
                String newPath = path + File.separator + element.getName();
                list(newPath);
            } else {
                fileList.add(element.getName());
            }
        }
    }

    private static String getPath(Class<TaskC> cClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + cClass
                .getName()
                .replace(cClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}
package by.it.bodukhin.jd01_14;

import by.it.bodukhin.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskC {

    private static ArrayList<File> listWithFileNames = new ArrayList<>();
    private static ArrayList<String> listWithFolderNames = new ArrayList<>();

    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        String pathBodukhin = getPathBodukhin();
        getFolders(pathBodukhin);
        getListFiles(pathBodukhin);
        printToConsole();
        printToFile(path);
    }

    private static void printToFile(String path) {
        try (PrintWriter out = new PrintWriter(path + "resultTaskC.txt")) {
            for (File fil : listWithFileNames) {
                out.println("file:" + fil.getName());
            }
            for (String fol : listWithFolderNames) {
                out.println("dir:" + fol);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole() {
        for (File fil : listWithFileNames) {
            System.out.println("file:" + fil.getName());
        }

        for (String fol : listWithFolderNames) {
            System.out.println("dir:" + fol);
        }
    }

    private static void getListFiles(String path) {
        File f = new File(path);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
    }

    private static void getFolders(String path) {
        File f = new File(path);
        String[] folders = f.list();
        for (int i = 0; i < (folders.length - 1); i++) {
            listWithFolderNames.add(folders[i]);
        }
    }


    private static String getPathBodukhin() {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                Main.class
                        .getName()
                        .replace(Main.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    private static String getPath(Class<TaskC> cClass) {
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator +
                cClass.getName()
                        .replace(cClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}
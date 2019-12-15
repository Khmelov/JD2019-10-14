package by.it.zabauniuk.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    private static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }

    public static void main(String[] args) {

        String startPath = getPath(TaskC.class);  //method returns string
        Path currentPath = Paths.get(startPath);
        System.out.println(currentPath);
        String targetDir = "";

        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.startsWith("cd ")) {
                targetDir = line.substring(3).trim();
                line = "changeDir";
            }
            switch (line) {
                case "cd..": {
                    currentPath = dirUp(currentPath);
                    System.out.println(currentPath);
                    break;
                }
                case "changeDir": {
                    currentPath = changeDir(currentPath, targetDir);
                    System.out.println(currentPath);
                    break;
                }
                case "dir": {
                    dir(currentPath);
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }


    private static void dir(Path currentPath) {
        try {
            for (Path path : Files.newDirectoryStream(currentPath)) {
                StringBuilder sb = new StringBuilder();
                String dirMarker = "";
                if (Files.isDirectory(path)) {
                    dirMarker = "DIR";
                }
                String size = "";
                if (!Files.isDirectory(path)) {
                    size = String.valueOf(Files.size(path));
                }
                System.out.printf("%-25s%5s%8s%20s%n",
                        Files.getLastModifiedTime(path), dirMarker, size, path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path dirUp(Path currentPath) {
        String path = currentPath.toString();
        String newPathString = path.substring(0, path.length() - 1).substring(0, path.lastIndexOf(File.separator));
        Path newPath = Paths.get(newPathString);
        return newPath;
    }

    private static Path changeDir(Path currentPath, String targetDir) {
        String path = currentPath.toString();
        String newPathString = path + File.separator + targetDir;
        Path newPath = Paths.get(newPathString);
        return newPath;

    }
}
package by.it.zabauniuk.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    private static String family = "zabauniuk";
    private static String path = getPackagePath(TaskC.class, family);
    private static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        Path startingDir = Paths.get(path);

        try {
            Files.walkFileTree(startingDir, new MyVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // print to console
        for (String s : fileList) {
            System.out.println(s);
        }
        // print to file
        String outputPath = OutputPath(TaskC.class);
        try (PrintWriter out = new PrintWriter(
                new FileWriter(outputPath + "resultTaskC.txt"))
        ) {
            for (String s : fileList) {
                out.print(s + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String OutputPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }

    private static String getPackagePath(Class<?> clazz, String family) {
        String systemPath = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(".", File.separator);
        Pattern pattern = Pattern.compile(family + "(.)*");
        Matcher matcher = pattern.matcher(subPath);
        String packagePath = "";
        // add case "if (!matcher.find())"
        if (matcher.find()) {
            packagePath = subPath.replace(matcher.group(), family + File.separator);
        }
        return systemPath + packagePath;
    }

    private static class MyVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Path shortName = dir.getFileName();
            fileList.add("dir:" + shortName.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile()) {
                String shortName = file.getFileName().toString();
                fileList.add("file:" + shortName);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
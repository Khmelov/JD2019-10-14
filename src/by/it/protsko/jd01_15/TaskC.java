package by.it.protsko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class TaskC {
    private static StringBuilder tasksPath = new StringBuilder(getPath(TaskC.class));
//    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        String line;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(tasksPath + " ");

            line = sc.nextLine();
            int numberSwitch = 0;

            if (line.matches("dir")) numberSwitch = 1;
            if (line.matches("cd ..")) numberSwitch = 2;
            if (line.matches("cd [a-zA-z0-9]+")) numberSwitch = 3;
            if (line.equals("end")) numberSwitch = 4;

            switch (numberSwitch) {
                case 1: {   // command "dir"
                    getDirInformation(tasksPath.toString());
                    break;
                }

                case 2: {   // command "cd .."
                    int index = 0;
                    char[] chars = tasksPath.toString().toCharArray();
                    if (chars.length > 3) {
                        for (int i = chars.length - 2; i > 0; i--) {
                            if (chars[i] == '\\') {
                                index = i;
                                break;
                            }
                        }
                    }
                    tasksPath = tasksPath.delete(index, tasksPath.length() - 1);
                    break;
                }

                case 3: {   //command "cd "
                    String dir = line.replaceAll("cd ", "");
                    boolean isDirNameValid = false;
                    File file = new File(tasksPath.toString());
                    for (File listFile : file.listFiles()) {
                        if (listFile.isDirectory()) {
                            if (listFile.getName().equals(dir)) {
                                tasksPath.append(dir).append("\\");
                                isDirNameValid = true;
                                break;
                            }
                        }
                    }
                    if (!isDirNameValid) {
                        System.out.println("Incorrect dir value!\n");
                    }
                    break;
                }

                case 4: {
                    System.out.println("----- PROGRAM COMPLETE -----");
                    break;
                }

                default: {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Incorrect data");
                    }
                }
            }
        } while (!line.equals("end"));
    }

    private static void getDirInformation(String path) throws IOException {
        File file = new File(path);
        int dirCount = 0;
        int fileCount = 0;
        long totalFileSize = 0;

        System.out.println("\nСодержимое папки " + tasksPath.toString() + "\n");
        for (File dirElement : file.listFiles()) {
            BasicFileAttributes attr = Files.readAttributes(Paths.get(tasksPath.toString() + dirElement.getName()), BasicFileAttributes.class);
            if (dirElement.isDirectory()) {
                System.out.printf("%-12s%-8s%-8s%8s  %-20s\n", getDataValue(attr), getTimeValue(attr), "<DIR>", "", dirElement.getName());
                dirCount++;
            } else {
                System.out.printf("%-12s%-8s%-8s%,8d  %-20s\n", getDataValue(attr), getTimeValue(attr), "", attr.size(), dirElement.getName());
                fileCount++;
                totalFileSize += attr.size();
            }
        }
        System.out.printf("\n%15s%-5d%-10s%,-8d%-5s\n", "", fileCount, "файлов", totalFileSize, "байт");
        System.out.printf("%15s%-5d%-10s\n\n", "", dirCount, "папок");
    }

    private static String getDataValue(BasicFileAttributes attr) {
        StringBuilder dateValue = new StringBuilder();
        String[] dateAndTime = attr.lastModifiedTime().toString().replaceAll("-", ".").split("T");
        String[] date = dateAndTime[0].split("\\.");

        for (int i = date.length - 1; i >= 0; i--) {
            if (i != 0) {
                dateValue.append(date[i]).append(".");
            } else {
                dateValue.append(date[i]);
            }
        }
        return dateValue.toString();
    }

    private static String getTimeValue(BasicFileAttributes attr) {
        StringBuilder timeValue = new StringBuilder();
        String[] dateAndTime = attr.lastModifiedTime().toString().replaceAll("-", ".").split("T");
        String[] time = dateAndTime[1].split(":");
        for (int i = 0; i < 2; i++) {
            if (i != 1) {
                timeValue.append(time[i]).append(":");
            } else {
                timeValue.append(time[i]);
            }
        }
        return timeValue.toString();
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

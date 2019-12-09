package by.it.yurtsevich.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = getPath(TaskC.class);
        File fl = new File(path);
        System.out.println("parent:" + fl.getParent());
        System.out.println(path+":");
        double sum = 0;
        for (; ; ) {
            String str = sc.nextLine();
            String[] sArray = str.split(" ");
            if (sArray[0].equals("end"))
                break;
            else if (sArray[0].equals("dir")) {
                for (File f: fl.listFiles())
                    System.out.println( new Date(f.lastModified()) + (f.isDirectory()? " <dir> ": "       ") + f.getName());
            } else if (sArray[0].equals("cd")) {
                if (sArray.length > 1) {
                    if (sArray[1].equals("..")) {
                        fl = fl.getParentFile();
                        System.out.println(fl.getAbsolutePath());
                    } else {
                        fl = new File(fl.getAbsolutePath(), sArray[1]);
                        System.out.println(fl.getAbsolutePath());
                    }
                }
            } else System.out.println("неизвестная команда");
        }
    }

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(File.separator+taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}

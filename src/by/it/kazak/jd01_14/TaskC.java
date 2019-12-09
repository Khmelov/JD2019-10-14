package by.it.kazak.jd01_14;


import java.io.*;
import java.util.Objects;


public class TaskC {

    public static void main(String[] args) throws IOException {
        //write
        Class<by.it.kazak.jd01_14.TaskC> cClass = by.it.kazak.jd01_14.TaskC.class;
        String p = System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                cClass
                        .getName()
                        .replace(cClass.getSimpleName(), "")
                        .replace(".", File.separator) +"resultTaskC.txt";
        System.out.println(p);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(p));
        } catch (IOException ex) {
            System.out.println("Ошибка записи" + ex);
        }

        String path = getPath();
        StringBuilder sb = new StringBuilder();
        System.out.println(path);
        File f = new File(path);
        if(f.isDirectory()) {
            for (File item : Objects.requireNonNull(f.listFiles())) {
                if(item.isDirectory()) {
                    sb.append("dir:").append(item.getName()).append("\n");
                    for (File file : Objects.requireNonNull(item.listFiles())){
                        sb.append("file:").append(file.getName()).append("\n");
                    }
                }
                else if(item.isFile()){
                    sb.append("file:").append(item.getName()).append("\n");
                }
            }
            System.out.println(sb);
        }
        assert bw != null;
        bw.append(sb);
        bw.close();
    }


    private static String getPath() {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                TaskC.class
                        .getSimpleName()
                        .replace(TaskC.class.getSimpleName(), "")
                        .replace(".", File.separator)  + "by\\it\\kazak" + File.separator;

    }
}



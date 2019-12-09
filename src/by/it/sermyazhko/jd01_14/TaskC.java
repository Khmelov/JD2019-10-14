package by.it.sermyazhko.jd01_14;
import java.io.*;

class TaskC {
    public static void main(String[] args) throws IOException {
        //write
        Class<TaskC> cClass = TaskC.class;
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

        String path = getPath(TaskC.class);
        StringBuilder sb = new StringBuilder();
        System.out.println(path);
        File f = new File(path);
        if(f.isDirectory()) {
            for (File item : f.listFiles()) {
                if(item.isDirectory()) {
                    sb.append("dir:").append(item.getName()).append("\n");
                    for (File file : item.listFiles()){
                        sb.append("file:").append(file.getName()).append("\n");
                    }
                }
                else if(item.isFile()){
                    sb.append("file:").append(item.getName()).append("\n");
                }
            }
            System.out.println(sb);
        }
        bw.append(sb);
            if(bw!=null) bw.close();
    }


    private static String getPath(Class<TaskC> cClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                cClass
                        .getSimpleName()
                        .replace(cClass.getSimpleName(), "")
                        .replace(".", File.separator)  + "by\\it\\sermyazhko" + File.separator;

    }
}


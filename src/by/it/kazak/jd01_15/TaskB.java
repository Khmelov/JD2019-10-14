package by.it.kazak.jd01_15;

/*
 * В программе создайте хотя бы 5 разных комментариев:
 * 2 однострочных, 2 многострочных и 1 JavaDoc
 * Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 * Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 * Результат вывести на консоль и в файл с тем же местоположением и именем,
 * но с расширением txt,а не java.
 * Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”)
 * Регулярные выражения использовать нельзя
 */

import java.io.*;

public class TaskB {

    private static StringBuilder sb = new StringBuilder();

    //Метод получения пути к фалу
    private static String getName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskB.class.getPackage().getName().replace(".", File.separator);
        return src + strPackage + File.separator + "TaskB.txt";
    }

    public static void main(String[] args) {
        String filename = getName();
        readFile(filename);
        writeFile();
        showFile();
    }

    //Читает файл с диска
    private static void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = br.readLine()) != null) {
                StringBuilder sbLine = new StringBuilder(s).append('\n');
                if (s.contains("/") && check(s)) {
                    sbLine.delete(sbLine.indexOf("/"), sbLine.length()).append('\n');
                }
                String changeLine = sbLine.toString();
                if (changeLine.contains("*") && check(s)) {
                    continue;
                }
                sb.append(sbLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод возвращает истину если строка не содержит con  ind*/
    private static boolean check(String s) {
        return !s.contains("contains") && !s.contains("indexOf");
    }

    //Сохраняет файл на диск
    private static void writeFile() {
        String fileNameForWrite = getName();
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(fileNameForWrite))) {

            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Выводит
     *содержимое
     *файла
     *в
     *консоль
     */
    private static void showFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(getName()))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

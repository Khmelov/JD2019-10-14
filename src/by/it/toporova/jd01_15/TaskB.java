package by.it.toporova.jd01_15;

import java.io.*;

//Класс TaskB
//В программе создайте хотя бы 5 разных комментариев: 2 однострочных,
// 2 многострочныхи 1 JavaDoc
//Программа должна прочитать свой собственный текст в переменную
// типа StringBuilder.
//Читая программу необходимо удалить все возможные виды комментариев,
// не трогая остальное.
//Результат вывести на консоль и в файл с тем же местоположением и именем,
// но с расширением txt,а не java.
//Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”)и
// внутри комментария тоже /** bla… /*так не бывает*/bla… //и так тожеbla… */. Регулярные выражения использовать нельзя
public class TaskB {


    public static void main(String[] args) {
        String result = createFile(TaskB.class, "TaskB.txt");
        //вызов метода создания файла
        String read = createFile(TaskB.class, "TaskB.java");
        readFile(read, result);
        showFile(result);
    }


    private static void deleteComments(StringBuilder sourceCode) {
        int start;
        int end;
        while ((start = sourceCode.indexOf("/\u002f")) >= 0 && (end = sourceCode.indexOf("\n", start)) >= 0) {
            sourceCode.delete(start, end);
        }
        while ((start = sourceCode.indexOf("\u002f*")) >= 0 && (end = sourceCode.indexOf("*\u002f")) >= 0) {
            sourceCode.delete(start, end + 2);
        }
    }



    /* в этом методе происходит чтение файла результата
      и вывод его в консоль */

    private static void showFile(String result) {
        try (BufferedReader reader = new BufferedReader(new FileReader(result))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





            /* Этот метод читает файл, построчное добавляет в StringBuilder и удаляет все комментарии
             */

    private static void readFile(String read, String result)  {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(read));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            deleteComments(sb);
            System.out.println(sb);
            String line2 = sb.toString();
            bufferedWriter.write(line2);
            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param taskBClass класс, в котором описана программа
     * @param name       имя файла создания/прочтения
     * @return путь к файлу
     */

    private static String createFile(Class<TaskB> taskBClass, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        //D:\JavaCourse\JD2019-10-14_ver01\src\
       // System.out.println("src " + src);
        String replacePath = taskBClass.getPackage().getName().replace(".", File.separator);
        //getPackage - package by.it.toporova.jd01_15
        //getPackage().getName(). - by.it.toporova.jd01_15
        //System.out.println("replacePath " + replacePath);
       // System.out.println(src + replacePath + File.separator + name);
        return (src + replacePath + File.separator + name);
    }


}

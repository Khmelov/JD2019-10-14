package by.it.toporova.jd01_12;
//TaskC1.Нужно ввести с консоли текст до строки end.
// Во входном тексте хранятся наименования некоторых объектов, по одному в строке.
// Строки иногда повторяются.
//Построить список C1, элементы которого содержат наименования и уникальные шифры
// данных объектов, причем элементы списка должны быть упорядочены по возрастанию шифров
// (шифр –некоторое случайное, но гарантированно уникальное число).
//Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
//Выведите полученный ассоциативный массив в консоль


import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        List<String> cFirst = new ArrayList<>();
        Map<String, Integer> c1 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            text = scanner.nextLine();
            if (text.equals("end")) break;
            sb.append(text).append('\n');
        }
        System.out.println("вывод после добавления слов в StringBuilder: " + sb);

        String[] list = sb.toString().split("\n");
        for (int i = 0; i < list.length; i++) {
            cFirst.add(list[i]);
            c1.put(list[i], i + 1);
        }
        System.out.println("вывод массива слов: " + Arrays.toString(list));

        System.out.println(cFirst);
        // entrySet() возвращает набор ключ-значений
        //
        c1.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

}

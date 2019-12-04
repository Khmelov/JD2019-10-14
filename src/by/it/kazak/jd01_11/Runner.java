package by.it.kazak.jd01_11;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

 //TaskA
        System.out.println("TaskA tests:");
        List<String> list = new ListA<>();
        list.add("Fedor"); //Добавление текста в массив
        list.add("Igor");
        list.add("Gzhegosh");
        System.out.println(list);  //Вывод массива в консоль
        list.remove(1);     //Удаление элемента в массиве с индексом 1
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.size());    //Вывод размера массива в консоль
        System.out.println(list);
        list.add(1, "Name");    //Добавление элемента в массив на определенное место
        System.out.println(list);


//TaskB
        System.out.println("TaskB tests:");
        List<String> listB1 = new ListB<>();
        listB1.add("Katya");
        listB1.add("Nika");
        listB1.add("Vera");
        System.out.println(listB1);
        System.out.println(listB1.set(0,"Valeron"));
        System.out.println(listB1);
        System.out.println(listB1);
        listB1.add(1,"Name");
        System.out.println(listB1);

//TaskC
        System.out.println("TaskC tests:");
        Set<String> array = new HashSet<>();
        array.add("one");
        array.add("two");
        array.add("three");
        System.out.println(array);
    }
}

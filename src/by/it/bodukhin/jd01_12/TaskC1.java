package by.it.bodukhin.jd01_12;


import java.util.*;
import java.util.List;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,String> mapList = new TreeMap<>();
        List<String> text = new ArrayList<>();
        scanner.useDelimiter("[^a-zA-Z']+");
        for(;;){
            String word = scanner.next();
            if (word.equals("end")) break;
            text.add(word);
            mapList.put(word.hashCode(), word);
        }

        System.out.println("Изначальные значения");
        for (int i = 0; i < text.size(); i++) {
            System.out.println(text.get(i).hashCode()+" "+text.get(i));
        }

        System.out.println("Значения после сортировки");
        for(Map.Entry<Integer,String> entry : mapList.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
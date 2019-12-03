package by.it.bodukhin.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        scanner.useDelimiter("[^a-zA-Z']+");
        for(;;){
            String word = scanner.next();
            if (word.equals("end")) break;
            text.add(word);
        }

        Set<String> oneWord = new HashSet<>(text);

        for (int i = 0; i < oneWord.size(); i++) {
            int freq = Collections.frequency(text,oneWord.toArray()[i]);
            System.out.println(oneWord.toArray()[i] + "=" + freq);
        }
    }
}

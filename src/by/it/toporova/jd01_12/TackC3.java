package by.it.toporova.jd01_12;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TaskC3.В консоль вводится строка,
// состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
//Проверьте и выведите в консоль корректность расстановки скобок
// (true или false) с помощью коллекций.
public class TackC3 {

    public static boolean checkBrackets(String string) {
        //списки для хранения позиций скобок
        ArrayList<Integer> openBrackets = new ArrayList<>();
        ArrayList<Integer> closeBrackets = new ArrayList<>();

        Pattern patternOpen = Pattern.compile("\\(");
        Matcher matcherOpen = patternOpen.matcher(string);
        while (matcherOpen.find()) {
            int position = matcherOpen.start();
            openBrackets.add(position);
        }

        Pattern patternClose = Pattern.compile("\\)");
        Matcher matcherClose = patternClose.matcher(string);
        while (matcherClose.find()) {
            int position = matcherClose.start();
            closeBrackets.add(position);
        }

        if (openBrackets.size() == closeBrackets.size()) {
            //если скобок нет, выражение корректно
            if (openBrackets.size() == 0) {
                System.out.println("Выражение без скобок");
                return true;
            }
            //если одна из открывающих скобок стоит позже закрывающих, выражение некорректно
            for (int i = 0; i < closeBrackets.size(); i++) {
                if (openBrackets.get(i) > closeBrackets.get(i)) {
                    System.out.println("Ошибка в порядке скобок");
                    return false;
                }
            }
        }
        else {
            System.out.println("Ошибка в кол-ве скобок");
            return false;
        }

        System.out.println("Выражение со скобками корректно");
        return true;
    }

}

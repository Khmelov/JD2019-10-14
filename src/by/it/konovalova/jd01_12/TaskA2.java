package by.it.konovalova.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] second = {2, 7, 8, 4, 3, 6, 6, 5, 1, 8, 1};

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(first));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(second));
        System.out.println(getCross(treeSet, hashSet));
        System.out.println(getUnion(treeSet, hashSet));


    }

    private static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }


}

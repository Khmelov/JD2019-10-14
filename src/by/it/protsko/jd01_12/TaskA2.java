package by.it.protsko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    private static Set<Integer> getCross(Set<? extends Integer> set1, Set<? extends Integer> set2) {
        Set<Integer> crossSet = new HashSet<>(set1);
        crossSet.retainAll(set2);
        return crossSet;
    }

    private static Set<Integer> getUnion(Set<? extends Integer> set1, Set<? extends Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14));

        System.out.println(getCross(set1, set2));
        System.out.println(getUnion(set1, set2));
    }
}
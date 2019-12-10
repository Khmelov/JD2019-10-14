package by.it.protsko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> intSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> intSet2 = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> intSet3 = new TreeSet<>(Arrays.asList(4, 5, 6, 7));
        Set<Integer> intSet4 = new TreeSet<>(Arrays.asList(7, 8, 9, 10));
        Set<Integer> intSet5 = new HashSet<>(Arrays.asList(1, 2, 11, 12));

        System.out.println(getCross(intSet1, intSet2, intSet3, intSet4, intSet5));
        System.out.println(getUnion(intSet1, intSet2, intSet3, intSet4, intSet5));

        Set<Double> doubleSet1 = new HashSet<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Set<Double> doubleSet2 = new TreeSet<>(Arrays.asList(1.0, 7.0, 8.0, 9.0, 1.0, 1.1, 1.2, 1.3, 1.4));
        Set<Double> doubleSet3 = new TreeSet<>(Arrays.asList(1.0, 15.0, 16.0, 1.7, 1.8, 1.9, 2.0));
        Set<Double> doubleSet4 = new TreeSet<>(Arrays.asList(1.0, 21.0, 22.0, 23.0, 2.4, 2.5, 2.6, 2.7));
        Set<Double> doubleSet5 = new HashSet<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 2.8));

        System.out.println(getCross(doubleSet1, doubleSet2, doubleSet3, doubleSet4, doubleSet5));
        System.out.println(getUnion(doubleSet1, doubleSet2, doubleSet3, doubleSet4, doubleSet5));
    }

    @SafeVarargs                                                    /////////////////Суть аннотации???????
    private static <T extends Number> Set getCross(Set<T>... v) {
        Set<T> crossSet = new HashSet<>(v[0]);
        for (int i = 1; i < v.length; i++) {
            Set<T> set = new HashSet<>(v[i]);
            crossSet.retainAll(set);
        }
        return crossSet;
    }

    @SafeVarargs
    private static <T extends Number> Set getUnion(Set<T>... v) {
        Set<T> unionSet = new HashSet<>(v[0]);
        for (int i = 1; i < v.length; i++) {
            unionSet.addAll(v[i]);
        }
        return unionSet;
    }
}

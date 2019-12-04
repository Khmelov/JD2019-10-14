package by.it.bodukhin.jd01_12;

import java.util.*;

public class TaskC2 {

    //Манипуляции всех множеств относительно первого, можно сдлать относительно результата предыдущих,
    //для этого убрать комментарий и добавить его в цикле
    static void getCross(Set<Number> left, Set<Number> ... right) {
        //Set<Number> result = new HashSet<>(left);
        for (int i = 0; i < right.length; i++) {
            Set<Number> result = new HashSet<>(left);
            result.retainAll(right[i]);
            System.out.println(result);
        }
    }

    static void getUnion(Set<Number> left, Set<Number> ... right){
        //Set<Number> result = new HashSet<>(left);
        for (int i = 0; i < right.length; i++) {
            Set<Number> result = new HashSet<>(left);
            result.addAll(right[i]);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Integer[] left = {1,1,1,1,1,1,4,5,6,7,8,10,66};
        Integer[] right = {2,4,5,6,4,43,3,2,4,4,66,9};
        Integer[] right2 = {1,2,2,2,2,4,4,5,5,6,9,9,8,10};
        HashSet<Number> hashSet = new HashSet<>(Arrays.asList(left));
        TreeSet<Number> treeSet = new TreeSet<>(Arrays.asList(right));
        HashSet<Number> hashSet2 = new HashSet<>(Arrays.asList(right2));
        getCross(hashSet,treeSet, hashSet2);
        getUnion(hashSet, treeSet, hashSet2);

        System.out.println();

        Double[] doubleLeft = {1.1,2.2,3.3};
        Double[] doubleRight = {4.4,5.5,6.6};
        Double[] doubleRight2 = {1.1,5.5,3.3};
        HashSet<Number> hashSetD = new HashSet<>(Arrays.asList(doubleLeft));
        TreeSet<Number> treeSetD = new TreeSet<>(Arrays.asList(doubleRight));
        HashSet<Number> hashSetD2 = new HashSet<>(Arrays.asList(doubleRight2));
        getCross(hashSetD,treeSetD,hashSetD2);
        getUnion(hashSetD,treeSetD,hashSetD2);


    }
}

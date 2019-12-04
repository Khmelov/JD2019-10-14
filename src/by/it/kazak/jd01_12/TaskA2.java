package by.it.kazak.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right){
        Set<Integer> result = new HashSet<>(left);
        result.retainAll(right);
        return result;
    }
    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right){
        Set<Integer> result = new HashSet<>(left);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        Integer[] left = {1,2,3,4,5,6,7,8,9,0};
        Integer[] right = {1,0,2,9,3,8,4,7,5,6};
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(left));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(right));
        System.out.println(hashSet);
        System.out.println(treeSet);
        Set<Integer> cross = getCross(hashSet, treeSet);
        System.out.println(cross);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(union);
    }
}

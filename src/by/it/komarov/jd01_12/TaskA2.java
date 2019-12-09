package by.it.komarov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {


    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right){
        Set<Integer> cross=new HashSet<>(left);
        cross.retainAll(right);
        return cross;
    }

    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right){
        Set<Integer> union=new HashSet<>(left);
        union.addAll(right);
        return union;
    }

    public static void main(String[] args) {
        HashSet<Integer> left=new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        TreeSet<Integer> right=new TreeSet<>(Arrays.asList(4,5,6,7,8,9,10,0));
        System.out.println(left);
        System.out.println(right);
        System.out.println(getCross(left, right));
        System.out.println(getUnion(left, right));

    }

}

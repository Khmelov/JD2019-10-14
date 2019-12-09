package by.it.yaroshenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
   public static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
       //Set<Integer> set = new HashSet<>(one);
       one.retainAll(two);
       return one;
   }
    public static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> set = new HashSet<>(one);
        set.addAll(two);
        return set;
    }
    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1,2,32,4,5,14,7,34,4,8,5,3,2,17));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,34,4,8,5,3,2,17));
        System.out.println(getCross(a,b));
        System.out.println(getUnion(a,b));
//        boolean cross = a.retainAll(b);
//        System.out.println(cross);
    }
}

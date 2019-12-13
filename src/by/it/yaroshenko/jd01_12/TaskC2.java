package by.it.yaroshenko.jd01_12;
import java.util.*;

public class TaskC2 {
    public static void createIntegerArray () {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,7,23,4,5,14,7,34,4,3,5,3,2,17));
        Set<Integer> b = new HashSet<>(Arrays.asList(6,8,22,4,5,14,7,34,4,2,5,3,2));
        Set<Integer> c = new HashSet<>(Arrays.asList(5,9,24,4,5,14,7,34,4,1,5,3));
        Set<Integer> d = new HashSet<>(Arrays.asList(4,2,32,4,5,14,7,34,4,4,5));
       // System.out.println(getCrossInteger(a,b,c,d));
    }
    public static void createDoubleArray () {
        HashSet<Double> e = new HashSet<>(Arrays.asList(1.0,7.0,23.0,4.0,5.0,14.0,7.0,34.0,4.0,3.0,5.0,3.0,2.0,17.0));
        HashSet<Double> f = new HashSet<>(Arrays.asList(6.0,8.0,22.0,4.0,5.0,14.0,7.0,34.0,4.0,2.0,5.0,3.0,2.0));
        HashSet<Double> g = new HashSet<>(Arrays.asList(5.0,9.0,24.0,4.0,5.0,14.0,7.0,34.0,4.0,1.0,5.0,3.0));
        HashSet<Double> h = new HashSet<>(Arrays.asList(4.0,2.0,32.0,4.0,5.0,14.0,7.0,34.0,4.0,4.0,5.0));
    }

//        private static <T> Set<T> getCrossInteger(Set<?>... sets){
//        boolean b=true;
//            Set<T> result = new HashSet<>();
//            Set<T> getunion = (Set<T>) getUnion(sets);
//            Iterator<T> iterator = getunion.iterator();
//            while (iterator.hasNext()) {
//                T t = iterator.next();
//                for (Set<?> set : sets) {
//                    if (set.contains(t)) {
//                        b=true;
//                    }
//                    if(b) {
//                       return result.retainAll(t);
//                    }
//                }
//            }
//        //Set<Integer> set = new HashSet<>(one);
////        one.retainAll(two);
//       return one;
//    }
    public static <E> Set<E> getUnion(Set<? extends E>...sets){
      //  Set<?> set = new HashSet<>(one);
//        one.addAll(two);
//        return one;
        return null;
    }
    public static void main(String[] args) {

//        HashSet<?> a = new HashSet<>(Arrays.asList(1,7,23,4,5,14,7,34,4,3,5,3,2,17));
//
//        TreeSet<?> b = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,7,34,4,8,5,3,2,17));
//        System.out.println(getCross(a,b));
//        System.out.println(getUnion(a,b));
//        boolean cross = a.retainAll(b);
//        System.out.println(cross);
    }
}

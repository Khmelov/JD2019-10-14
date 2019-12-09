package by.it.protsko.jd01_11;

import java.util.HashSet;
import java.util.Set;

class RunnerSet {

    public static void main(String[] args) {
        SetC<Integer> setC = new SetC<>();
        Set<Integer> javaSet = new HashSet<>();

        javaSet.add(10);   setC.add(null);
        javaSet.add(20);   setC.add(20);
        javaSet.add(30);   setC.add(30);
        javaSet.add(40);   setC.add(40);
        javaSet.add(50);   setC.add(50);
        javaSet.add(40);   setC.add(null);
        javaSet.add(40);   setC.add(40);
        javaSet.add(50);   setC.add(50);
        javaSet.add(80);   setC.add(150);
        setC.add(80);

        System.out.println("JAVA: " +javaSet +"  " +javaSet.size());
        System.out.println("LIST: " +setC +"  " +setC.size());

        javaSet.remove(30);   setC.remove(30);

        System.out.println("JAVA: " +javaSet +"  " +javaSet.size());
        System.out.println("LIST: " +setC +"  " +setC.size());

//        javaSet.addAll(setC);   //setC.addAll(setC);
//
//        System.out.println("JAVA: " +javaSet);
//        System.out.println("LIST: " +setC);



    }
}

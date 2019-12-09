package by.it.yaroshenko.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> lbList = new ListB<>();
        List<String> addAllList = new ListB<>();
        List<String> arrList = new ArrayList<>();

        myList.add("First"); arrList.add("First");
        myList.add("Two"); arrList.add("Two");
        myList.add("Four"); arrList.add("Four");
        System.out.println("mylist"+myList+"\narList"+arrList);

        lbList.add("First"); //arrList.add("First");
        lbList.add("Two"); //arrList.add("Two");
        lbList.add("Four"); //arrList.add("Four");
        lbList.set(0,"xxx"); //arrList.set(0,"xxx");
        System.out.println("lblist"+lbList+"\nlbList"+arrList);

        addAllList.add("First"); //arrList.add("First");
        addAllList.add("Two"); //arrList.add("Two");
        addAllList.add("Four"); //arrList.add("Four");
        boolean b = addAllList.addAll(myList);//arrList.set(0,"xxx");
        System.out.println("addAllList");
        System.out.println(b);


        myList.add("Tree"); arrList.add("Tree");
        myList.add(0,"Tree"); arrList.add(0,"Tree");
        myList.add(2,"Start"); arrList.add(2,"Start");
        System.out.println("mylist"+myList+"\narList"+arrList);
        myList.remove("Start"); arrList.remove("Start");
        myList.remove(3); arrList.remove(3);
        System.out.println("mylist"+myList+"\narList"+arrList);
        System.out.println("mylist(0) "+myList.get(0)+"\narList(0) "+arrList.get(0));
    }
}

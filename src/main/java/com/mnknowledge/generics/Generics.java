package com.mnknowledge.generics;

import com.mnknowledge.MySorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Generics stuff.
 */
public class Generics {
    public static void main(String[] args) {
        callNonGeneric();
        /*MyClass<Integer> mc = new <String>MyClass<Integer>("adf");
        MyClass<Integer> mc1 = new MyClass<>("adf");
        MyClass<Integer> mc2 = new MyClass<>(12, 45);*/
//        MyClass<Integer> mc3 = new MyClass<>("info", "text");
    }

    private static void callNonGeneric() {
        final List list = nonGenericNumList();
        final Object element = list.get(0);
        final int sum = (int) element + 14;
        System.out.println(sum);
    }

    //    @SuppressWarnings("unchecked")
    private static List nonGenericNumList() {
        final List list = new ArrayList();
        list.add("Java 9 is here");
        list.add("Weak type checks");
        return list;
    }

    private static List<Integer> genericNumList() {
        return List.of(12, 45, 73);
    }

    private static void callGeneric() {
        List<Integer> typeSafeList = genericNumList();
        final Integer elem = typeSafeList.get(0);
        final int sum = elem + 14;
        System.out.println("Generic way: " + sum);
    }
}
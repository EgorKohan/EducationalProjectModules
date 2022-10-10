package com.test.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list1.add(2);
        lists.add(list1);
        lists.add(list2);
        lists.stream().flatMap(Collection::stream).forEach(System.out::println);
    }

    private static void foo1(SomeInterface<?> someInterface) {
        System.out.println(someInterface.getValue());
    }

    private static void foo2(SomeInterface<? extends Number> someInterface) {
        System.out.println(someInterface.getValue());
    }

}

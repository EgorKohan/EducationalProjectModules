package main.tests;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    private static class Element
    {
        private final int value;

        public Element(int value) { this.value = value; }

        public int getValue() { return value; }
    }

    private static volatile int counter = 0;

    public static void main(String[] args)
    {
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < 100 * 1000; i++)
        {
            list.add(new Element(1));
        }
        list.stream().forEach(e -> counter += e.getValue());
        System.out.println(counter);
    }

}

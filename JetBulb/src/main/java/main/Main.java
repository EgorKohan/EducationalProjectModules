package main;

import tests.A;
import tests.B;
import tests.*;

import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Person superPerson = new SuperPerson("Egor");

        A a = new A();
        B b = new B();

        Person person = a.getPerson();
        person = new Person("Dima");
        b.person = new Person("Andrey");

        System.out.println(a.getPerson());
        System.out.println(b.person);

        SuperPerson superPerson1 = new SuperPerson();

        System.out.println("-------------------------------------------------");

        AbstroImpl abstro = new AbstroImpl();
        abstro.sayHello();

        System.out.println("--------------------------------------------------");

        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        hashSet.add(1);
        hashSet.add("abc");
        hashSet.add(1.213F);
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add(null);

//        treeSet.add(1);
//        treeSet.add("asd");

        System.out.println("---------------------------------------------------");
        // Hashtable устарел + синхронайзед везде

        CustomEnum egor = CustomEnum.EGOR;
        System.out.println(egor.getName());


    }

}

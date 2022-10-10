package com.hazelcast.docs;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.map.listener.EntryAddedListener;
import org.checkerframework.checker.units.qual.K;

public class Test {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        IMap<Object, Object> myMap = hazelcastInstance.getMap("MyMap");
        myMap.addEntryListener(new MyListener(), true);
        myMap.put("1", "2");
        myMap.put("2", "2");
        myMap.put("3", "2");
        System.out.println("The end");
    }

    private static class MyListener implements EntryAddedListener<String, String> {
        @Override
        public void entryAdded(EntryEvent<String, String> event) {
            System.out.println("Entry was added = " + event.getValue());
        }
    }

}

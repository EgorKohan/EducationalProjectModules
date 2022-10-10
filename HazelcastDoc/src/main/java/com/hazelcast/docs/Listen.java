package com.hazelcast.docs;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.map.MapEvent;
import com.hazelcast.map.listener.*;

public class Listen {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(HazelcastConfigHolder.getConfig());
        IMap<Object, Object> map = hazelcastInstance.getMap("somemap");
        map.addEntryListener(new MyEntryListener(), true);
        System.out.println("EntryListener added");
    }

    public static class MyEntryListener implements
            EntryAddedListener<String, String>,
            EntryRemovedListener<String, String>,
            EntryUpdatedListener<String, String>,
            EntryEvictedListener<String, String>,
            EntryLoadedListener<String, String>,
            MapEvictedListener,
            MapClearedListener {

        @Override
        public void entryAdded(EntryEvent<String, String> event) {
            System.out.println("Entry added: " + event);
        }

        @Override
        public void entryEvicted(EntryEvent<String, String> event) {
            System.out.println("Entry evicted: " + event);
        }

        @Override
        public void entryLoaded(EntryEvent<String, String> event) {
            System.out.println("Entry loaded: " + event);
        }

        @Override
        public void entryRemoved(EntryEvent<String, String> event) {
            System.out.println("Entry removed: " + event);
        }

        @Override
        public void entryUpdated(EntryEvent<String, String> event) {
            System.out.println("Entry updated: " + event);
        }

        @Override
        public void mapCleared(MapEvent event) {
            System.out.println("Map cleared: " + event);
        }

        @Override
        public void mapEvicted(MapEvent event) {
            System.out.println("Map evicted: " + event);
        }
    }

}

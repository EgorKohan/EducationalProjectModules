package com.hazelcast.docs;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HelloWorld {

    public static void main(String[] args) {
        Config config = new Config();
        NetworkConfig network = config.getNetworkConfig();
        network.getJoin().getMulticastConfig().setEnabled(false);
        network.getJoin().getTcpIpConfig().setEnabled(true);
        network.setPortAutoIncrement(true);
        network.setPort(33001);
        network.getJoin().getTcpIpConfig().addMember("127.0.0.1");
        config.setClusterName("hazelcast-home");

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance hazelcastInstance1 = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance hazelcastInstance2 = Hazelcast.newHazelcastInstance(config);

        IMap<Object, Object> map = hazelcastInstance.getMap("my-distributed-map");
        map.put("1", "John");
        map.put("2", "Mary");
        map.put("3", "Jane");

        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));

    }

}

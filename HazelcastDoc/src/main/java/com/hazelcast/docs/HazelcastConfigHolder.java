package com.hazelcast.docs;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;

public class HazelcastConfigHolder {

    private static Config config = null;

    private HazelcastConfigHolder() {
    }

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
            NetworkConfig network = config.getNetworkConfig();
            network.getJoin().getMulticastConfig().setEnabled(false);
            network.getJoin().getTcpIpConfig().setEnabled(true);
            network.setPortAutoIncrement(true);
            network.setPort(33001);
            network.getJoin().getTcpIpConfig().addMember("127.0.0.1");
            config.setClusterName("hazelcast-home");
//            MapConfig somemap = config.getMapConfig("somemap");
//            somemap.addEntryListenerConfig(new EntryListenerConfig(new Listen.MyEntryListener(), false, true));
//            System.out.println("EventEntryListener added");
        }
        return config;
    }


}

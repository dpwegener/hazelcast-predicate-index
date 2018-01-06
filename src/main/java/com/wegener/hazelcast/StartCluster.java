package com.wegener.hazelcast;


import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class StartCluster {
    public static void main(String[] args) {
        Config cfg = new Config();
        MapConfig mapConfig = new MapConfig("indexed");
        mapConfig.addMapIndexConfig(new MapIndexConfig("name", false));
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setClassName("com.wegener.hazelcast.PersonLoader");
        mapStoreConfig.setEnabled(true);
        mapConfig.setMapStoreConfig(mapStoreConfig);
        cfg.addMapConfig(mapConfig);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        System.out.println("Ready");
    }

}

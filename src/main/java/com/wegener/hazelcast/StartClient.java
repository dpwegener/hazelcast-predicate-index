package com.wegener.hazelcast;

import java.util.Collection;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;

public class StartClient {
    public static void main( String[] args ) {
        ClientConfig clientConfig = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
        IMap map = client.getMap( "customers" );
        System.out.println( "Map Size:" + map.size() );
        IMap<String, Person> indexedMap = client.getMap("indexed");
        
        EntryObject eo = new PredicateBuilder().getEntryObject();
        Predicate p = eo.get("name").equal("Name2499");
        Collection<Person> results = indexedMap.values(p);
        System.out.println("Results size: " + results.size());
        results.forEach((person) -> System.out.println(person));
        System.out.println(indexedMap.get("Name4999"));
        System.out.println(indexedMap.get("Name1"));
        System.out.println(indexedMap.get("Name2499"));
    }

}

package com.wegener.hazelcast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hazelcast.core.MapStore;

public class PersonLoader implements MapStore<String, Person> {

	@Override
	public Person load(String arg0) {
		System.out.println("Creating unloaded Person " + arg0);
		return new Person(arg0);
	}

	@Override
	public Map<String, Person> loadAll(Collection<String> arg0) {
		Map<String, Person> results = new HashMap<>();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arg0.forEach((n) -> results.put(n, new Person(n)));
		return results;
	}

	@Override
	public Iterable<String> loadAllKeys() {
		System.out.println("LoadAllKeys returning Iterable...............");
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					private int count = 0;
					@Override
					public boolean hasNext() {
						return count < 5000;
					}

					@Override
					public String next() {
						return "Name" + count++;
					}
				};
			}
		};
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(String arg0, Person arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeAll(Map<String, Person> arg0) {
		// TODO Auto-generated method stub
		
	}

}

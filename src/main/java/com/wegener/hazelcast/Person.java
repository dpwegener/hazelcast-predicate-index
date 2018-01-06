package com.wegener.hazelcast;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private String dummy;
	
	public Person(String name) {
		this.name = name;
		this.dummy = name + name;
	}
	
	public String toString() {
		return "Person{name='" + name + "' dummy='" + dummy + "'}";
	}

}

package com.test.coreJavaConcepts;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class coreJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// HashMap -- non sync not thread safe, allows one null key and any null values
		HashMap<Integer, String> hm = new HashMap<>();
		for (Entry<Integer, String> ent : hm.entrySet()) {
			System.out.println("Name " + ent.getKey() + " is " + ent.getValue());
		}

		for (Map.Entry<Integer, String> ent : hm.entrySet()) {
			System.out.println("For loop Name " + ent.getKey() + " is " + ent.getValue());
		}

		// HashTable -- sync and is thread safe, null keys and values not allowed
		Hashtable<Integer, String> ht = new Hashtable<>();
		ht.put(1, "abcef");
		ht.put(2, "defgh");
for (Entry<Integer, String> ent : ht.entrySet()) {
			System.out.println("HT Name " + ent.getKey() + " is " + ent.getValue());
		}

		for (Map.Entry<Integer, String> ent : hm.entrySet()) {
			System.out.println("HT For loop Name " + ent.getKey() + " is " + ent.getValue());
		}

	}

}

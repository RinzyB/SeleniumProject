package coreJavaConcepts;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class coreJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// HashMap -- non sync not thread safe, allows one null key and any null values
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "abc");
		hm.put(2, "def");
//		hm.put(1, "efg");
//		hm.remove(1);
		Iterator it = hm.entrySet().iterator();
		while (it.hasNext()) {
			// System.out.println("it.next() --> "+it.next()); // it.next() --> 1=abc
			Map.Entry<Integer, String> ent = (Map.Entry<Integer, String>) it.next();
			System.out.println("Name " + ent.getKey() + " is " + ent.getValue());
		}

		for (Map.Entry<Integer, String> ent : hm.entrySet()) {
			System.out.println("For loop Name " + ent.getKey() + " is " + ent.getValue());
		}

		// HashTable -- sync and is thread safe, null keys and values not allowed
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "abcef");
		ht.put(2, "defgh");
//				hm.put(1, "efg");
//				hm.remove(1);
		Iterator itt = ht.entrySet().iterator();
		while (itt.hasNext()) {
			// System.out.println("it.next() --> "+it.next()); // it.next() --> 1=abc
			Map.Entry<Integer, String> ent = (Map.Entry<Integer, String>) itt.next();
			System.out.println("HT Name " + ent.getKey() + " is " + ent.getValue());
		}

		for (Map.Entry<Integer, String> ent : hm.entrySet()) {
			System.out.println("HT For loop Name " + ent.getKey() + " is " + ent.getValue());
		}

	}

}

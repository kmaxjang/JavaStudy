package com.sample;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class SimpleLinkedHashSetExample {

	public static void main(String[] args) {
		// create object of LinkedHashSet
		LinkedHashSet<Integer> lhashSet = new LinkedHashSet<>();

		System.out.println("Size of LinkedHashSet : " + lhashSet.size());

		lhashSet.add(Integer.valueOf("1"));
		lhashSet.add(Integer.valueOf("2"));
		lhashSet.add(Integer.valueOf("3"));

		System.out.println("Size of LinkedHashSet after addition : " + lhashSet.size());
	    lhashSet.remove(Integer.valueOf("1"));
	    System.out.println("Size of LinkedHashSet after removal : " + lhashSet.size());
		
	    System.out.println("LinkedHashSet contains.." + lhashSet);
	    
		 boolean blnExists = lhashSet.contains(Integer.valueOf("3"));
	        System.out.println("3 exists in LinkedHashSet ? : " + blnExists);	        
		/*
		 * Output of the program would be LinkedHashSet contains..[1, 2, 3]
		 */
	        lhashSet.clear();
	        System.out.println("LinkedHashSet after removal : " + lhashSet);
	        System.out.println("Is LinkedHashSet empty ? " + lhashSet.isEmpty());

	        
	        //create object of LinkedHashMap
	        LinkedHashMap<String, Integer> lHashMap = new LinkedHashMap<>();

	        lHashMap.put("One", Integer.valueOf(1));
	        lHashMap.put("Two", Integer.valueOf(2));
	    
	        //retrieve value using Object get(Object key) method of Java LinkedHashMap class
	        Integer obj = lHashMap.get("One");
	        System.out.println(obj);

	}
}

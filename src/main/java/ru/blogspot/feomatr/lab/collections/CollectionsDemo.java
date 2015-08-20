package ru.blogspot.feomatr.lab.collections;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * @author polovinkin.igor
 * @since 20.08.2015
 */
public class CollectionsDemo {

	public static void main(String[] args) {

		HashMap<Integer, Integer> hashMap = Maps.newHashMap();
		TreeMap<Integer, Integer> treeMap = Maps.newTreeMap();
		//This linked list defines the iteration ordering,
		// which is normally the order in which keys were inserted into the map (insertion-order).
		LinkedHashMap<Integer, Integer> linkedHashMap = Maps.newLinkedHashMap();
		IdentityHashMap<Integer, Integer> identityHashMap = Maps.newIdentityHashMap();
		WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<>();
		for (int i = 10; i > 0; --i) {
			System.out.println(i);
			hashMap.put(i, i);
			treeMap.put(i, i);
			linkedHashMap.put(i, i);
			identityHashMap.put(i, i);
			weakHashMap.put(i, i);
		}
		System.out.println("hashMap = " + hashMap);
		System.out.println("treeMap = " + treeMap);
		System.out.println("linkedHashMap = " + linkedHashMap);
		System.out.println("identityHashMap = " + identityHashMap);
		System.out.println("weakHashMap = " + weakHashMap);
	}

}

package com.joepritzel.gildedrose.service;

import comalexaitken.gildedrose.model.Item;

/**
 * Compares Items.
 * 
 * @author Joe Pritzel
 * 
 */
public class ItemComparisonService {

	/**
	 * Determines if two Items are equal based on their values, and ignores the
	 * sellIn variable.
	 * 
	 * @param i
	 *            - The first item.
	 * @param i1
	 *            - The second item.
	 * @return Returns true if the items are equal, otherwise false.
	 */
	public static boolean equalsIgnoreSellIn(Item i, Item i1) {
		
		if((i == null && i1 != null) || (i != null && i1 == null)) {
			return false;
		}
		
		if (!i.getName().equals(i1.getName())) {
			return false;
		}

		if (i.getQuality() != i1.getQuality()) {
			return false;
		}

		return true;
	}

	/**
	 * Determines if two Items are equal based on their values.
	 * 
	 * @param i
	 *            - The first item.
	 * @param i1
	 *            - The second item.
	 * @return Returns true if the items are equal, otherwise false.
	 */
	public static boolean equals(Item i, Item i1) {
		if (!i.getName().equals(i1.getName())) {
			return false;
		}

		if (i.getQuality() != i1.getQuality()) {
			return false;
		}

		if (i.getSellIn() != i1.getSellIn()) {
			return false;
		}

		return true;
	}

}

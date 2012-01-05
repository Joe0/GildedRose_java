package com.alexaitken.gildedrose.service;

import com.alexaitken.gildedrose.model.Item;

/**
 * This service clones Item objects.
 * 
 * @author Joe Pritzel
 * 
 */
public class ItemCloningService {

	/**
	 * Clones the given item.
	 */
	public static Item clone(Item item) {
		return new Item(item.getName(), item.getSellIn(), item.getQuality());
	}
}

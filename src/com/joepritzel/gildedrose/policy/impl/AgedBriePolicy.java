package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * The policy for 'Aged Brie'.
 * 
 * @author Joe Pritzel
 * 
 */
public class AgedBriePolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().equals("Aged Brie")) {
			item.setQuality(item.getQuality() + 1);
		}
		return item;
	}

}

package com.alexaitken.gildedrose.policy.impl;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

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

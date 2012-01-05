package com.alexaitken.gildedrose.policy.impl;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

/**
 * Reduces quality by two per day.
 * 
 * @author Joe Pritzel
 * 
 */
public class ConjuredPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().toLowerCase().startsWith("conjured")) {
			item.setQuality(item.getQuality() - 2);
		}
		return item;
	}

}

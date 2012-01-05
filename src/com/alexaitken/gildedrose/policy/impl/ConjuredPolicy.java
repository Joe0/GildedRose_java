package com.alexaitken.gildedrose.policy.impl;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

/**
 * Reduces quality by two per day, and twice that after sellin.
 * 
 * @author Joe Pritzel
 * 
 */
public class ConjuredPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().toLowerCase().startsWith("conjured")) {
			int rate = 2;
			if (item.getSellIn() <= 0) {
				rate *= 2;
			}
			item.setQuality(item.getQuality() - rate);
		}
		return item;
	}

}

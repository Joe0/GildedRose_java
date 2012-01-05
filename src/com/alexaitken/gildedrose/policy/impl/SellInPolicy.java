package com.alexaitken.gildedrose.policy.impl;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

/**
 * Reduces the sellin date.<br>
 * Should apply to all items.
 * 
 * @author Joe Pritzel
 * 
 */
public class SellInPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		item.setSellIn(item.getSellIn() - 1);
		return item;
	}

}

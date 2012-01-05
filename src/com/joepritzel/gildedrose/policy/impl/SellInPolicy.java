package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.model.Item;
import com.joepritzel.gildedrose.policy.Policy;

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

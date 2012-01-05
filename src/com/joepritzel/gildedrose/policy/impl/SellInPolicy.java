package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

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

package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.model.Item;
import com.joepritzel.gildedrose.policy.Policy;

/**
 * The default policy, which just decreases the quality by one.
 * 
 * @author Joe Pritzel
 * 
 */
public class DefaultPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		int rate = 1;
		if(item.getSellIn() < 0) {
			rate *= 2;
		}
		item.setQuality(item.getQuality() - rate);
		return item;
	}

}

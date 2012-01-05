package com.alexaitken.gildedrose.policy.impl;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

/**
 * The policy for 'Sulfuras, Hand of Ragnaros'.
 * 
 * @author Joe Pritzel
 * 
 */
public class SulfurasPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			return null;
		}
		return item;
	}

}

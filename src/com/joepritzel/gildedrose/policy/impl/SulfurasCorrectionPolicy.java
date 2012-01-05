package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * The correction policy for 'Sulfuras, Hand of Ragnaros'.
 * 
 * @author Joe Pritzel
 * 
 */
public class SulfurasCorrectionPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			return null;
		}
		return item;
	}

}

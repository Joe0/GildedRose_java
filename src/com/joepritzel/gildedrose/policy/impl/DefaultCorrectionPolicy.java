package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * The default correction policy.
 * 
 * @author Joe Pritzel
 * 
 */
public class DefaultCorrectionPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getQuality() > 50) {
			item.setQuality(50);
		}

		if (item.getQuality() < 0) {
			item.setQuality(0);
		}

		return item;
	}

}

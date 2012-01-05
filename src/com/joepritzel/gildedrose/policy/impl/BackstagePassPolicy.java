package com.joepritzel.gildedrose.policy.impl;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * The policy for 'Backstage passes to a TAFKAL80ETC concert'.
 * 
 * @author Joe Pritzel
 * 
 */
public class BackstagePassPolicy implements Policy {

	@Override
	public Item apply(Item item) {
		if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.getSellIn() <= 0) {
				item.setQuality(0);
			} else if (item.getSellIn() <= 5) {
				item.setQuality(item.getQuality() + 3);
			} else if (item.getSellIn() <= 10) {
				item.setQuality(item.getQuality() + 2);
			} else {
				item.setQuality(item.getQuality() + 1);
			}
		}
		return item;
	}

}

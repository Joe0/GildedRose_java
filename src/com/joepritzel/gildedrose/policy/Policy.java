package com.joepritzel.gildedrose.policy;

import com.joepritzel.gildedrose.model.Item;

/**
 * The Policy interface, which is used to modify Items.
 * 
 * @author Joe Pritzel
 * 
 */
public interface Policy {

	/**
	 * Applies some operation to the item, and returns the new item.
	 * 
	 * @param item
	 *            - The item to copy.
	 * @return - The changed item. If no change, it will just return the
	 *         original.  To flag without change, return null.
	 */
	public Item apply(Item item);
}

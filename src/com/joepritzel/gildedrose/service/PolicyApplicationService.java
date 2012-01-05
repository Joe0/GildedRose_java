package com.joepritzel.gildedrose.service;

import java.util.List;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * Applies multiple policies to items.
 * 
 * @author Joe Pritzel
 * 
 */
public class PolicyApplicationService {

	/**
	 * Applies a list of policies to a single item.
	 * 
	 * @param policies
	 *            - The policies to apply.
	 * @param i
	 *            - The item to apply the policies to.
	 * @return The item with all policies applied.
	 */
	public static Item applyPolicies(List<Policy> policies, Item i) {

		Item current = ItemCloningService.clone(i);
		for (Policy p : policies) {
			if (current == null) {
				break;
			}
			current = p.apply(current);
		}
		
		return current;
	}

	/**
	 * Applies a list of policies to a single item. If not changed, the default
	 * policies will be applied.
	 * 
	 * @param policies
	 *            - The policies to apply.
	 * @param defaultPolicies
	 *            - The policies to apply if the item is unchanged.
	 * @param i
	 *            - The item to apply the policies to.
	 * @return The item with the proper policies applied to it.
	 */
	public static Item applyPolicies(List<Policy> policies,
			List<Policy> defaultPolicies, Item i) {
		Item current = applyPolicies(policies, i);

		if (ItemComparisonService.equalsIgnoreSellIn(i, current)) {
			current = applyPolicies(defaultPolicies, current);
		}

		if (current == null) {
			return i;
		}
		return current;
	}
}

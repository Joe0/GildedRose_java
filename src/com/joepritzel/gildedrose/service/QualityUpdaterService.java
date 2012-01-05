package com.joepritzel.gildedrose.service;

import java.util.ArrayList;
import java.util.List;

import com.joepritzel.gildedrose.policy.Policy;
import comalexaitken.gildedrose.model.Item;

/**
 * Updates the quality of items.
 * 
 * @author Joe Pritzel
 * 
 */
public class QualityUpdaterService {

	private static final List<Policy> policies = new ArrayList<>();
	private static final List<Policy> defaultPolicies = new ArrayList<>();

	/**
	 * Registers a policy with the QualityUpdaterService.
	 * 
	 * @param p - The policy to register
	 * @param def - True if it should be default, false if not.
	 */
	public static void registerPolicy(Policy p, boolean def) {
		if (!def) {
			policies.add(p);
		} else {
			defaultPolicies.add(p);
		}
	}
	
	/**
	 * Registers a non-default policy with the QualityUpdaterService.
	 * 
	 * @param p - The policy to register
	 */
	public static void registerPolicy(Policy p) {
		registerPolicy(p, false);
	}

	/**
	 * Updates the item based on the given policies. If no policies change the
	 * item, then the default policies will be applied.
	 * 
	 * @param item
	 *            - The item to update.
	 * @return The updated item.
	 */
	public static Item update(Item item) {
		return PolicyApplicationService.applyPolicies(policies,
				defaultPolicies, item);
	}
}

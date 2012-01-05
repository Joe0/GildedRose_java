package com.alexaitken.gildedrose.service;

import java.util.ArrayList;
import java.util.List;

import com.alexaitken.gildedrose.model.Item;
import com.alexaitken.gildedrose.policy.Policy;

/**
 * 
 * Corrects the bounds of the quality for item.
 * 
 * @author Joe Pritzel
 * 
 */
public class QualityBoundsCorrectionService {

	private static List<Policy> policies = new ArrayList<>();
	private static List<Policy> defaultPolicies = new ArrayList<>();

	/**
	 * Registers a policy with the QualityCorrectionService.
	 * 
	 * @param p
	 *            - The policy to register
	 * @param def
	 *            - True if it should be default, false if not.
	 */
	public static void registerPolicy(Policy p, boolean def) {
		if (!def) {
			policies.add(p);
		} else {
			defaultPolicies.add(p);
		}
	}

	/**
	 * Registers a non-default policy with the QualityCorrectionService.
	 * 
	 * @param p
	 *            - The policy to register
	 */
	public static void registerPolicy(Policy p) {
		registerPolicy(p, false);
	}

	/**
	 * Corrects the bounds of the given item.
	 * 
	 * @param i
	 *            - The item to correct bounds of.
	 * @return The corrected item.
	 */
	public static Item correct(Item i) {
		return PolicyApplicationService.applyPolicies(policies,
				defaultPolicies, i);
	}
}

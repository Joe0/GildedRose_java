package test.com.alexaitken.gildedrose;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.joepritzel.gildedrose.policy.impl.*;
import com.joepritzel.gildedrose.service.QualityBoundsCorrectionService;
import com.joepritzel.gildedrose.service.QualityUpdaterService;
import comalexaitken.gildedrose.model.Inventory;
import comalexaitken.gildedrose.model.Item;

/**
 * Tests for Gilded Rose Kata.
 * 
 * @author Alex Aitken
 * @author Joe Pritzel
 * 
 */
public class InventoryTest {
	// new Item("+5 Dexterity Vest", 10, 20),
	// new Item("Aged Brie", 2, 0),
	// new Item("Elixir of the Mongoose", 5, 7),
	// new Item("Sulfuras, Hand of Ragnaros", 0, 80),
	// new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
	// new Item("Conjured Mana Cake", 3, 6)

	@BeforeClass
	public static void registerPolicies() {
		// Default QualityUpdaterServices
		QualityUpdaterService.registerPolicy(new DefaultPolicy(), true);
		QualityUpdaterService.registerPolicy(new SellInPolicy(), true);

		// Specific QualityUpdaterServices
		QualityUpdaterService.registerPolicy(new AgedBriePolicy());
		QualityUpdaterService.registerPolicy(new SulfurasPolicy());
		QualityUpdaterService.registerPolicy(new BackstagePassPolicy());
		QualityUpdaterService.registerPolicy(new ConjuredPolicy());

		// Specific QualityCorrectionServices
		QualityBoundsCorrectionService
				.registerPolicy(new SulfurasCorrectionPolicy());

		// Default QualityCorrectionServices
		QualityBoundsCorrectionService.registerPolicy(
				new DefaultCorrectionPolicy(), true);
	}

	@Test
	public void should_never_changes_quailty_of_Sulfuras() throws Exception {
		Inventory sut = new Inventory((Item[]) Arrays.asList(
				new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());

		sut.updateQuality();

		assertEquals(80, sut.getItem(0).getQuality());

	}

	@Test
	public void should_never_changes_sellIn_of_Sulfuras() throws Exception {
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

		Inventory sut = new Inventory((Item[]) Arrays.asList(sulfuras)
				.toArray());

		sut.updateQuality();

		assertEquals(0, sut.getItem(0).getSellIn());

	}

	@Test
	public void should_lower_the_sellIn_by_one_for_normal_items()
			throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 20);

		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem)
				.toArray());

		sut.updateQuality();

		assertEquals(9, sut.getItem(0).getSellIn());
	}

	@Test
	public void should_lower_the_quality_by_one_for_normal_items()
			throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 20);

		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem)
				.toArray());

		sut.updateQuality();

		assertEquals(19, sut.getItem(0).getQuality());
	}

	@Test
	public void should_not_lower_the_quality_below_zero() throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", 10, 0);

		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem)
				.toArray());

		sut.updateQuality();

		assertEquals(0, sut.getItem(0).getQuality());
	}

	@Test
	public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed()
			throws Exception {
		Item normalItem = new Item("+5 Dexterity Vest", -1, 25);

		Inventory sut = new Inventory((Item[]) Arrays.asList(normalItem)
				.toArray());

		sut.updateQuality();

		assertEquals(23, sut.getItem(0).getQuality());
	}

	@Test
	public void should_increase_the_quality_of_aged_brie_as_it_gets_older()
			throws Exception {
		Item agedBrie = new Item("Aged Brie", 10, 25);

		Inventory sut = new Inventory((Item[]) Arrays.asList(agedBrie)
				.toArray());

		sut.updateQuality();
		assertEquals(26, sut.getItem(0).getQuality());
	}

	@Test
	public void should_not_increase_the_quality_of_aged_brie_over_50()
			throws Exception {
		Item agedBrie = new Item("Aged Brie", 10, 50);

		Inventory sut = new Inventory((Item[]) Arrays.asList(agedBrie)
				.toArray());

		sut.updateQuality();

		assertEquals(50, sut.getItem(0).getQuality());
	}

	@Test
	public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened()
			throws Exception {
		Item backStagePass = new Item(
				"Backstage passes to a TAFKAL80ETC concert", -1, 20);

		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass)
				.toArray());

		sut.updateQuality();

		assertEquals(0, sut.getItem(0).getQuality());
	}

	@Test
	public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away()
			throws Exception {
		Item backStagePass = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 11, 20);

		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass)
				.toArray());

		sut.updateQuality();

		assertEquals(21, sut.getItem(0).getQuality());
	}

	@Test
	public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away()
			throws Exception {
		Item backStagePass = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 10, 27);

		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass)
				.toArray());

		sut.updateQuality();

		assertEquals(29, sut.getItem(0).getQuality());
	}

	@Test
	public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away()
			throws Exception {
		Item backStagePass = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 5, 44);

		Inventory sut = new Inventory((Item[]) Arrays.asList(backStagePass)
				.toArray());

		sut.updateQuality();

		assertEquals(47, sut.getItem(0).getQuality());
	}

	@Test
	public void should_not_increase_backstage_passes_above_a_quality_of_50()
			throws Exception {
		Item backStagePassMoreThan10DaysAway = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 15, 50);

		Item backStagePass10DaysAway = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 5, 49);
		Item backStagePass5DaysAway = new Item(
				"Backstage passes to a TAFKAL80ETC concert", 5, 48);

		Inventory sut = new Inventory((Item[]) Arrays.asList(
				backStagePassMoreThan10DaysAway, backStagePass10DaysAway,
				backStagePass5DaysAway).toArray());

		sut.updateQuality();

		assertEquals(50, sut.getItem(0).getQuality());
		assertEquals(50, sut.getItem(1).getQuality());
		assertEquals(50, sut.getItem(2).getQuality());
	}

	@Test
	public void conjured_items_should_degrade_twice_as_fast() throws Exception {
		Inventory inv = new Inventory(new Item[] {
				new Item("Conjured Mana Cake", 3, 6),
				new Item("Conjured Mana Cake", -1, 6) });
		inv.updateQuality();
		assertEquals(4, inv.getItem(0).getQuality());
		assertEquals(2, inv.getItem(1).getQuality());
	}

	@Test
	public void conjured_items_should_have_bounds_checking() throws Exception {
		Inventory inv = new Inventory(new Item[] {
				new Item("Conjured Mana Cake", 3, 1),
				new Item("Conjured Mana Cake", 3, 55) });
		inv.updateQuality();
		assertEquals(0, inv.getItem(0).getQuality());
		assertEquals(50, inv.getItem(1).getQuality());
	}

}

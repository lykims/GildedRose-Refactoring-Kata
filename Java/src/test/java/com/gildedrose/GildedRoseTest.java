package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testDexterityVest() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);
    }

    @Test
    void testAgedBrie2() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(1, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void testElixirOfTheMongoose() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(4, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    void testSulfurasHandOfRagnaros() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void testSulfurasHandOfRagnaros2() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void testSulfurasHandOfRagnaros3() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(2, item.sellIn);
        assertEquals(49, item.quality);
    }

    @Test
    void testBackstagePassesToATAFKAL80ETCConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void testBackstagePassesToATAFKAL80ETCConcert2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void testBackstagePassesToATAFKAL80ETCConcert3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void testBackstagePassesToATAFKAL80ETCConcert4() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testConjuredManaCake() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(2, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    void testConjuredManaCake2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 4) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testConjuredManaCake3() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.items[0];
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
}

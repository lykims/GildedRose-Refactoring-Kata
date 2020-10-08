package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isLegendaryItem(item.name)) {
                updateQuality(item);
                updateSellIn(item);
                updateQualityAfterSellIn(item);
            }
        }
    }

    private void updateQuality(Item item) {
        if (isValuableItem(item.name)) {
            increaseQuality(item);
            updateBackstagePassQuality(item);
        } else {
            decreaseQuality(item);
            updateConjuredItemQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQualityAfterSellIn(Item item) {
        if (item.sellIn < 0) {
            if (isValuableItem(item.name)) {
                increaseQuality(item);
                updateBackstagePassQualityAfterSellIn(item);
            } else {
                decreaseQuality(item);
            }
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.name.startsWith("Backstage passes")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void updateBackstagePassQualityAfterSellIn(Item item) {
        if (item.name.startsWith("Backstage passes")) {
            item.quality = 0;
        }
    }

    private void updateConjuredItemQuality(Item item) {
        if (isConjuredItem(item.name)) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isLegendaryItem(String itemName) {
        return itemName.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isValuableItem(String itemName) {
        return itemName.equals("Aged Brie")
            || itemName.startsWith("Backstage passes");
    }

    private boolean isConjuredItem(String itemName) {
        return itemName.startsWith("Conjured");
    }
}
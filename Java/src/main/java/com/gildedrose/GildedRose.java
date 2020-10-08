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
        if (!isValuableItem(item.name)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);
            updateBackstagePassQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQualityAfterSellIn(Item item) {
        if (item.sellIn < 0) {
            if (!isValuableItem(item.name)) {
                decreaseQuality(item);
            } else {
                increaseQuality(item);
                updateBackstagePassQualityAfterSellIn(item);
            }
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void updateBackstagePassQualityAfterSellIn(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
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
            || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}
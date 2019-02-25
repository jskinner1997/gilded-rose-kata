package com.gildedrose;

public class AgedBrie extends CatalogItem {
    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void process() {
        int appreciation = item.sellIn > 0 ? APPRECIATION_RATE : APPRECIATION_RATE * 2;
        increaseQualityBy(appreciation);
        decreaseSellInFor(item);
    }
}
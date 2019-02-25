package com.gildedrose;

public class Conjured extends CatalogItem {
    public static final String CONJURED = "Conjured";

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void process() {

        decreaseSellInFor(item);

        if (sellInHasPassed()) {
            decreaseQualityBy(STANDARD_DEPRECIATION * 4);
        } else {
            decreaseQualityBy(STANDARD_DEPRECIATION * 2);
        }
    }
}

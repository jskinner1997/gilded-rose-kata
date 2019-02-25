package com.gildedrose;


public class StandardItem extends CatalogItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void process() {

        decreaseSellInFor(item);

        if (sellInHasPassed()) {
            decreaseQualityBy(STANDARD_DEPRECIATION * 2);
        } else
            decreaseQualityBy(STANDARD_DEPRECIATION);
    }
}
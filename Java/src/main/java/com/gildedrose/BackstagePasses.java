package com.gildedrose;

public class BackstagePasses extends CatalogItem {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void process() {
        if (concertWithin(5))
            increaseQualityBy(APPRECIATION_RATE * 3);
        else if (concertWithin(10))
            increaseQualityBy(APPRECIATION_RATE * 2);
        else
            increaseQualityBy(APPRECIATION_RATE);

        decreaseSellInFor(item);

        if (sellInHasPassed()) {
            item.quality = 0;
        }
    }

    private boolean concertWithin(int i) {
        return item.sellIn <= i;
    }
}
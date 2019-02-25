package com.gildedrose;

public abstract class CatalogItem {
    public static final int QUALITY_CEILING = 50;
    public static final int QUALITY_FLOOR = 0;
    protected static final int APPRECIATION_RATE = 1;
    protected static final int STANDARD_DEPRECIATION = 1;
    protected Item item;

    public CatalogItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public int sellIn() {
        return item.sellIn;
    }

    public int quality() {
        return item.quality;
    }

    public abstract void process();

    void decreaseSellInFor(Item item) {
        item.sellIn--;
    }

    void increaseQualityOf(Item item) {
        if (item.quality < QUALITY_CEILING)
            item.quality++;
    }

    void increaseQualityBy(int amount) {
        for (int i = 0; i < amount; i++) {
            increaseQualityOf(item);
        }
    }

    boolean sellInHasPassed() {
        return item.sellIn < 0;
    }

    void decreaseQualityOf(Item item) {
        if (item.quality > QUALITY_FLOOR)
            item.quality--;
    }

    void decreaseQualityBy(int amount) {
        for (int i = 0; i < amount; i++) {
            decreaseQualityOf(item);
        }
    }

}

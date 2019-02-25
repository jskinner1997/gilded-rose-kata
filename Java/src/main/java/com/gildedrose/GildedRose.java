package com.gildedrose;

class GildedRose {

    private final CatalogItem[] catalogItems;

    public GildedRose(CatalogItem... items) {
        catalogItems = items;
    }

    public void processEndOfDayUpdates() {
        for (CatalogItem item : catalogItems) {
            item.process();
        }
    }

    public CatalogItem item(int i) {
        return catalogItems[i];
    }
}
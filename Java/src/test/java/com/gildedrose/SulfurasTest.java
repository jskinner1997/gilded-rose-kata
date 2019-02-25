package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {
    @Test
    public void legendaryCatalogItemsNeverHaveToBeSoldOrDecreaseInQuality() {
        CatalogItem item = Create.sulfuras().sellIn(8).quality(10).obj();
        item.process();

        assertEquals(8, item.sellIn());
        assertEquals(10, item.quality());
    }
}

package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardItemTest {
    @Test
    public void atEndOfDaySystemLowersSellinDays() {
        CatalogItem item = Create.standardItem().sellIn(1).quality(2).obj();
        item.process();
        assertEquals(0, item.sellIn());
    }

    @Test
    public void atEndOfDaySystemLowersQuality() {
        CatalogItem item = Create.standardItem().sellIn(1).quality(2).obj();
        item.process();
        assertEquals(1, item.quality());

    }

    @Test
    public void onceSellByDateHasPassedQualityDegradesTwiceAsFast() {
        CatalogItem item = Create.standardItem().isExpired().quality(5).obj();
        item.process();
        assertEquals(3, item.quality());
    }

    @Test
    public void onceSellByDateHasPassedQualityDegradesTwiceAsFastButIsNeverNegative() {
        CatalogItem item = Create.standardItem().isExpired().quality(1).obj();
        item.process();
        assertEquals(0, item.quality());
    }

    @Test
    public void theQualityOfAnItemIsNeverNegative() {
        CatalogItem item = Create.standardItem().sellIn(0).quality(0).obj();
        assertEquals(0, item.quality());
    }

}

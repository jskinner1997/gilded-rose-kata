package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {
    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
        CatalogItem item = Create.agedBrie().sellIn(1).quality(5).obj();
        item.process();
        assertEquals(6, item.quality());
    }

    @Test
    public void agedBrieIncreasesInQualityTwiceAsFastAfterSellin() {
        CatalogItem item = Create.agedBrie().isExpired().quality(5).obj();
        item.process();
        assertEquals(7, item.quality());
    }

    @Test
    public void qualityOfAnCatalogItemIsNeverMoreThan50() {
        CatalogItem item = Create.agedBrie().quality(50).isExpired().obj();
        item.process();
        assertEquals(50, item.quality());
    }

    @Test
    public void agedBrieIncreasesInQualityTwiceAsFastButCapsAt50() {
        CatalogItem item = Create.agedBrie().isExpired().quality(49).obj();
        item.process();
        assertEquals(50, item.quality());
    }

}

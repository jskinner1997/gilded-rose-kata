package com.gildedrose;

import com.gildedrose.builder.Create;
import org.junit.Test;

import static com.gildedrose.BackstagePasses.BACKSTAGE_PASSES;
import static org.junit.Assert.assertEquals;

public class BackstagePassesTest {
    @Test
    public void backstagePassesIncreaseInQualityAsSellInApproaches() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(100).quality(10).obj();
        item.process();
        assertEquals(11, item.quality());
    }

    @Test
    public void backstagePassesIncreaseInQualityButCannotExceed50() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(4).quality(49).obj();
        item.process();
        assertEquals(50, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_twice_as_fast_when_within_10_days() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(10).quality(10).obj();
        item.process();
        assertEquals(12, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_twice_as_fast_when_within_10_days_but_stops_at_50() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(10).quality(49).obj();
        item.process();
        assertEquals(50, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_three_times_as_fast_when_within_5_days() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(5).quality(10).obj();
        item.process();
        assertEquals(13, item.quality());
    }

    @Test
    public void Backstage_passes_increases_in_quality_three_times_as_fast_when_within_5_days_but_stops_at_50() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(5).quality(49).obj();
        item.process();
        assertEquals(50, item.quality());
    }

    @Test
    public void Backstage_passes_quality_goes_to_zero_after_the_show() {
        CatalogItem item = Create.backstagePasses().name(BACKSTAGE_PASSES).sellIn(0).obj();
        item.process();
        assertEquals(0, item.quality());
    }
}

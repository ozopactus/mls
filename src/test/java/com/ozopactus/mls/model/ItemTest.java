package com.ozopactus.mls.model;

import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Victor
 */
public class ItemTest {
    @Test
    public void testMethods() {
        final String expected = "Item{part_number=QD-19, part_name=Steel box, vendor=China factory, qty=100, received=2018-01-27, shipped=2018-02-19}";

        Item item = new Item();
        item.setPart_number("QD-19");
        item.setPart_name("Steel box");
        item.setVendor("China factory");
        item.setQty(100);
        item.setReceived(new Date(1_517_000_000_000L));
        item.setShipped(new Date(1_519_000_000_000L));
        
        assertEquals(expected, item.toString());
    }
}

package com.app.sale.item;

import com.app.sale.TestWithSpring;
import com.app.sale.tax.BasicTax;
import com.app.sale.tax.ImportTax;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemTest extends TestWithSpring{

    private static final String NAME = "imported perfume";
    private static final double PRICE = 27.99;

    Item item = new Item(NAME, PRICE, new BasicTax(new ImportTax()));

    @Test
    public void testGetName() throws Exception {
        assertThat("Name", item.getName(), is(NAME));
    }

    @Test
    public void testGetPrice() throws Exception {
        assertThat("Price", item.getPrice(), is(PRICE));
    }

    @Test
    public void testGetPercentageTax() throws Exception {
        assertThat("Percentage Tax", item.getPercentageTax(), is(15.0));
    }
}
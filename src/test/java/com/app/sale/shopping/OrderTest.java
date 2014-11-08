package com.app.sale.shopping;

import com.app.sale.TestWithSpring;
import com.app.sale.item.Item;
import com.app.sale.tax.BasicTax;
import com.app.sale.tax.ImportTax;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrderTest extends TestWithSpring{

    Order order = new Order(new Item("imported bottle of perfume", 27.99, new BasicTax(new ImportTax())),1);

    @Test
    public void testSubTotal() throws Exception {
        assertThat("Sub total", order.subTotal().doubleValue(), is(27.99));
    }

    @Test
    public void testTax() throws Exception {
        assertThat("Tax", order.tax().doubleValue(), is(4.20));
    }

    @Test
    public void testTotal() throws Exception {
        assertThat("Total", order.total().doubleValue(), is(32.19));
    }
}
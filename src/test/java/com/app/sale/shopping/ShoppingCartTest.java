package com.app.sale.shopping;

import com.app.sale.item.Item;
import com.app.sale.TestWithSpring;
import com.app.sale.tax.BasicTax;
import com.app.sale.tax.DosmeticTax;
import com.app.sale.tax.ImportTax;
import com.app.sale.tax.TaxFree;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class ShoppingCartTest extends TestWithSpring{

    @Test
    public void testFirstInvoice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addOrder(new Order(new Item("book", 12.49, new TaxFree(new DosmeticTax())), 1));
        shoppingCart.addOrder(new Order(new Item("music CD", 14.99, new BasicTax(new DosmeticTax())), 1));
        shoppingCart.addOrder(new Order(new Item("chocolate bar", 0.85, new TaxFree(new DosmeticTax())), 1));

        System.out.print(shoppingCart);

        assertThat("Sales Taxes", shoppingCart.taxAmount().doubleValue(), is(1.50));
        assertThat("Total", shoppingCart.totalAmount().doubleValue(), is(29.83));
    }

    @Test
    public void testSecondInvoice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addOrder(new Order(new Item("imported box of chocolates", 10.00, new TaxFree(new ImportTax())), 1));
        shoppingCart.addOrder(new Order(new Item("imported bottle of perfume", 47.50, new BasicTax(new ImportTax())), 1));

        System.out.print(shoppingCart);

        assertThat("Sales Taxes", shoppingCart.taxAmount().doubleValue(), is(7.65));
        assertThat("Total", shoppingCart.totalAmount().doubleValue(), is(65.15));
    }

    @Test
    public void testThirdInvoice(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addOrder(new Order(new Item("imported bottle of perfume", 27.99, new BasicTax(new ImportTax())), 1));
        shoppingCart.addOrder(new Order(new Item("bottle of perfume", 18.99, new BasicTax(new DosmeticTax())), 1));
        shoppingCart.addOrder(new Order(new Item("packet of headache pills", 9.75, new TaxFree(new DosmeticTax())), 1));
        shoppingCart.addOrder(new Order(new Item("box of imported chocolates", 11.25, new TaxFree(new ImportTax())), 1));

        System.out.print(shoppingCart);

        assertThat("Sales Taxes", shoppingCart.taxAmount().doubleValue(), is(6.70d));
        assertThat("Total", shoppingCart.totalAmount().doubleValue(), is(74.68d));
    }

}
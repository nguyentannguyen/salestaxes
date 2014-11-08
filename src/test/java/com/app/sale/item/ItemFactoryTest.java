package com.app.sale.item;

import com.app.sale.TestWithSpring;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class ItemFactoryTest extends TestWithSpring {

    @Autowired
    private ItemFactory itemFactory;

    @Test
    public void whenItemIsGoodsNoTaxAndNonImportThenTaxIsNoCharged() throws Exception {
        Item item = itemFactory.createItem("book", 12.45, true, true);
        assertThat("Price", item.getPrice(),is(12.45));
        assertThat("Percentage Tax", item.getPercentageTax(),is(0.0));
    }

    @Test
    public void whenItemIsGoodsNoTaxAndDutyImportThenTaxIsDutyImportOnly() throws Exception {
        Item item = itemFactory.createItem("imported book", 12.45, true, false);
        assertThat("Price", item.getPrice(),is(12.45));
        assertThat("Percentage Tax", item.getPercentageTax(),is(5.0));
    }

    @Test
    public void whenItemIsGoodsBasicTaxAndNonImportThenTaxIsBasicTaxOnly() throws Exception {
        Item item = itemFactory.createItem("perfume", 18.99, false, true);
        assertThat("Price", item.getPrice(),is(18.99));
        assertThat("Percentage Tax", item.getPercentageTax(),is(10.0));
    }

    @Test
    public void whenItemIsGoodsBasicTaxAndDutyImportThenTaxIsBasicTaxPlusDutyImport() throws Exception {
        Item item = itemFactory.createItem("imported perfume", 27.99, false, false);
        assertThat("Price", item.getPrice(),is(27.99));
        assertThat("Percentage Tax", item.getPercentageTax(),is(15.0));
    }
}
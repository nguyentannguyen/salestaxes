package com.app.sale.item;

import com.app.sale.TestWithSpring;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TaxFreeGoodsServiceTest extends TestWithSpring{

    @Autowired
    private TaxFreeGoodsService taxFreeGoodsService;

    @Test
    public void testAddTaxFreeGoods() throws Exception {
        taxFreeGoodsService.addTaxFreeGoods("book");
        assertThat(taxFreeGoodsService.isTaxFreeGoods("book"), is(true));
    }

    @Test
    public void testIsTaxFreeGoods() throws Exception {
        taxFreeGoodsService.addTaxFreeGoods("perfume");
        assertThat(taxFreeGoodsService.isTaxFreeGoods("perfume"), is(true));

        taxFreeGoodsService.clear();
        assertThat(taxFreeGoodsService.isTaxFreeGoods("perfume"), is(false));
    }

    @Test
    public void testIsTaxFreeGoodsByNonExactName() throws Exception {
        taxFreeGoodsService.addTaxFreeGoods("chocolates");

        assertThat(taxFreeGoodsService.isTaxFreeGoods("chocolates milk"), is(true));
        assertThat(taxFreeGoodsService.isTaxFreeGoods("chocolat"), is(true));
    }
}
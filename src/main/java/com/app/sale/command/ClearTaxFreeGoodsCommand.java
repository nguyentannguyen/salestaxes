package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.item.TaxFreeGoodsService;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class ClearTaxFreeGoodsCommand extends Command{

    public static final String REGEX_CLEAR_TAXFREE_GOODS = "empty taxfree";

    public ClearTaxFreeGoodsCommand(String input){
        super(input);
    }

    @Override
    public String execute() {
        TaxFreeGoodsService taxFreeGoodsService = SpringApplicationContext.getBean(TaxFreeGoodsService.class);
        taxFreeGoodsService.clear();

        return "taxfree goods is empty";
    }
}

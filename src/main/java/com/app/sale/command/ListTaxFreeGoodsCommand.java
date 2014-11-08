package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.item.TaxFreeGoodsService;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class ListTaxFreeGoodsCommand extends Command{

    public static final String REGEX_LIST_TAXFREE_GOODS = "taxfree";

    public ListTaxFreeGoodsCommand(String input){
        super(input);
    }

    @Override
    public String execute() {
        TaxFreeGoodsService taxFreeGoodsService = SpringApplicationContext.getBean(TaxFreeGoodsService.class);
        return taxFreeGoodsService.toString();
    }
}

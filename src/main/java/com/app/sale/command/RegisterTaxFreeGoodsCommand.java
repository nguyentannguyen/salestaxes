package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.exception.UnrecognizedCommandException;
import com.app.sale.item.TaxFreeGoodsService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class RegisterTaxFreeGoodsCommand extends Command{

    public static final String REGEX_REGISTER_TAXFREE_GOODS = "(taxfree )([\\w]+)";

    public RegisterTaxFreeGoodsCommand(String input){
        super(input);
    }

    @Override
    public String execute() {
        Pattern p = Pattern.compile(REGEX_REGISTER_TAXFREE_GOODS);
        Matcher m = p.matcher(input);

        if (m.find()) {
            String goodsName = m.group(2);
            TaxFreeGoodsService taxFreeGoodsService = SpringApplicationContext.getBean(TaxFreeGoodsService.class);
            taxFreeGoodsService.addTaxFreeGoods(goodsName);

            return goodsName + " is taxfree goods";
        }

        throw new UnrecognizedCommandException();
    }
}

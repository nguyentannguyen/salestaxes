package com.app.sale.item;

import com.app.sale.tax.*;
import com.app.sale.tax.BasicTax;
import org.springframework.stereotype.Component;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
@Component
public class ItemFactory {

    public Item createItem(String name, double price, boolean isGoodsNoTax, boolean isDutyFree){

        DutyStrategy dutyStrategy = isDutyFree ? new DosmeticTax() : new ImportTax();
        TaxStrategy taxStrategy = isGoodsNoTax ? new TaxFree(dutyStrategy) : new BasicTax(dutyStrategy);
        return new Item(name, price, taxStrategy);
    }
}

package com.app.sale.shopping;

import com.app.sale.utils.BigDecimalUtil;
import com.app.sale.item.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class Order {

    private static final double HUNDRED_PERCENTAGE = 100.0;

    Item item;
    int quantity;

    public Order(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public BigDecimal subTotal(){
        return new BigDecimal(item.getPrice() * quantity).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal tax(){
        return BigDecimalUtil.roundUp(quantity * item.getPrice() * item.getPercentageTax() / HUNDRED_PERCENTAGE);
    }

    public BigDecimal total(){
        return subTotal().add(tax());
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", quantity, item.getName(), total());
    }
}

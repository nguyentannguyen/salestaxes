package com.app.sale.item;

import com.app.sale.tax.TaxStrategy;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class Item {

    private String name;
    private double price;
    private TaxStrategy taxStrategy;

    public Item(String name, double price, TaxStrategy taxStrategy) {
        this.name = name;
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPercentageTax() {
        return taxStrategy.getPercentageTax();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", taxStrategy=" + taxStrategy +
                '}';
    }
}

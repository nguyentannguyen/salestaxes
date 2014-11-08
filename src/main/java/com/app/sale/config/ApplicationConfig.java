package com.app.sale.config;


/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-04.
 */
public class ApplicationConfig {

    private double basicTax;
    private double importTax;

    public double getBasicTax() {
        return basicTax;
    }

    public void setBasicTax(double basicTax) {
        this.basicTax = basicTax;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return "SalesTaxesConfig{" +
                "basicTax=" + basicTax +
                ", importTax=" + getImportTax() +
                '}';
    }
}

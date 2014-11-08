package com.app.sale.tax;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public abstract class TaxStrategy {

    protected DutyStrategy dutyStrategy;

    public TaxStrategy(DutyStrategy dutyStrategy){
        this.dutyStrategy = dutyStrategy;
    }

    public abstract double getPercentageTax();
}

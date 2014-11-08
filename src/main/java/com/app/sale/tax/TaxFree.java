package com.app.sale.tax;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class TaxFree extends TaxStrategy {

    public TaxFree(DutyStrategy dutyStrategy) {
        super(dutyStrategy);
    }

    @Override
    public double getPercentageTax() {
        return dutyStrategy.getPercentageDutyTax();
    }
}

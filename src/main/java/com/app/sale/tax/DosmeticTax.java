package com.app.sale.tax;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class DosmeticTax implements DutyStrategy{

    @Override
    public double getPercentageDutyTax() {
        return 0.0;
    }
}

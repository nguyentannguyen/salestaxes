package com.app.sale.tax;

import com.app.sale.config.ApplicationConfig;
import com.app.sale.config.SpringApplicationContext;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class BasicTax extends TaxStrategy {

    public BasicTax(DutyStrategy dutyStrategy) {
        super(dutyStrategy);
    }

    @Override
    public double getPercentageTax() {
        ApplicationConfig applicationConfig = SpringApplicationContext.getBean(ApplicationConfig.class);
        return applicationConfig.getBasicTax() + dutyStrategy.getPercentageDutyTax();
    }
}

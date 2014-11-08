package com.app.sale.tax;

import com.app.sale.config.ApplicationConfig;
import com.app.sale.config.SpringApplicationContext;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class ImportTax implements DutyStrategy{
    @Override
    public double getPercentageDutyTax() {
        ApplicationConfig applicationConfig = SpringApplicationContext.getBean(ApplicationConfig.class);
        return applicationConfig.getImportTax();
    }
}

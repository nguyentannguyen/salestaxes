package com.app.sale.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class BigDecimalUtil {

    private static final double ROUNDING_FACTOR = 0.05d;
    private static final int DECIMAL_SCALE = 2;

    public static BigDecimal roundUp(double value){
        return new BigDecimal(Math.ceil(value / ROUNDING_FACTOR) * ROUNDING_FACTOR)
                .setScale(DECIMAL_SCALE, RoundingMode.FLOOR);
    }
}

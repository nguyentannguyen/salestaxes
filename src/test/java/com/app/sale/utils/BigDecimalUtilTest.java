package com.app.sale.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BigDecimalUtilTest {

    @Test
    public void testRoundUp() throws Exception {
        assertThat("Round up to 0.05", BigDecimalUtil.roundUp(12.400000001).doubleValue(), is(12.45));
        assertThat("Round up to 0.05", BigDecimalUtil.roundUp(12.46222).doubleValue(), is(12.50));
    }
}
package com.app.sale.command;

import com.app.sale.TestWithSpring;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-07.
 */
public class OrderCommandTest extends TestWithSpring{

    @Test
    public void testOrderCommand() throws Exception {
        String output1 = new OrderCommand("8 bottle of perfume at 18.99").execute();
        assertThat("Order", output1, is("8 bottle of perfume: 167.12"));

        String output2 = new OrderCommand("20 imported bottle of perfume at 27.99").execute();
        assertThat("Order", output2, is("20 imported bottle of perfume: 643.80"));
    }
}
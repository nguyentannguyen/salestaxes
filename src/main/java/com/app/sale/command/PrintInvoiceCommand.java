package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.shopping.ShoppingCart;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class PrintInvoiceCommand extends Command{

    public static final String REGEX_PRINT_INVOICE = "print";

    public PrintInvoiceCommand(String input){
        super(input);
    }

    @Override
    public String execute(){
        ShoppingCart shoppingCart = SpringApplicationContext.getBean(ShoppingCart.class);
        return shoppingCart.toString();
    }
}

package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.shopping.ShoppingCart;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class EmptyShoppingCartCommand extends Command{

    public static final String REGEX_EMPTY_SHOPPING_CART = "empty";

    public EmptyShoppingCartCommand(String input){
        super(input);
    }

    @Override
    public String execute(){
        ShoppingCart shoppingCart = SpringApplicationContext.getBean(ShoppingCart.class);
        shoppingCart.clear();

        return "Shopping Cart is empty";
    }
}

package com.app.sale.command;

import org.springframework.stereotype.Component;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
@Component
public class CommandFactory {

    public Command createCommand(String input){

        if (input.matches(OrderCommand.REGEX_ORDER)){
            return new OrderCommand(input);
        }
        else if (input.matches(PrintInvoiceCommand.REGEX_PRINT_INVOICE)) {
            return new PrintInvoiceCommand(input);
        }
        else if (input.matches(EmptyShoppingCartCommand.REGEX_EMPTY_SHOPPING_CART)) {
            return new EmptyShoppingCartCommand(input);
        }
        else if (input.matches(RegisterTaxFreeGoodsCommand.REGEX_REGISTER_TAXFREE_GOODS)) {
            return new RegisterTaxFreeGoodsCommand(input);
        }
        else if (input.matches(ListTaxFreeGoodsCommand.REGEX_LIST_TAXFREE_GOODS)) {
            return new ListTaxFreeGoodsCommand(input);
        }
        else if (input.matches(ClearTaxFreeGoodsCommand.REGEX_CLEAR_TAXFREE_GOODS)) {
            return new ClearTaxFreeGoodsCommand(input);
        }
        else {
            return new HelpCommand(input);
        }
    }
}

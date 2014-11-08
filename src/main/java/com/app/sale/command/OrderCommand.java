package com.app.sale.command;

import com.app.sale.config.SpringApplicationContext;
import com.app.sale.exception.UnrecognizedCommandException;
import com.app.sale.item.Item;
import com.app.sale.item.TaxFreeGoodsService;
import com.app.sale.shopping.Order;
import com.app.sale.shopping.ShoppingCart;
import com.app.sale.tax.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
public class OrderCommand extends Command{

    public static final String REGEX_ORDER = "([0-9]*)[ ]([\\w\\s]+)[ ](at)[ ]([0-9\\.]+)";

    public OrderCommand(String input){
        super(input);
    }

    @Override
    public String execute() {
        Order order = createOrder();
        ShoppingCart shoppingCart = SpringApplicationContext.getBean(ShoppingCart.class);
        shoppingCart.addOrder(order);

        return order.toString();
    }

    private Order createOrder(){
        Pattern p = Pattern.compile(REGEX_ORDER);
        Matcher m = p.matcher(input);

        if (m.find()) {
            String name = m.group(2);
            double price = Double.valueOf(m.group(4));
            int quantity = Integer.valueOf(m.group(1));

            DutyStrategy dutyStrategy = m.group(2).toUpperCase().contains("IMPORTED")
                    ? new ImportTax()
                    : new DosmeticTax();

            TaxFreeGoodsService taxFreeGoodsService = SpringApplicationContext.getBean(TaxFreeGoodsService.class);
            TaxStrategy taxStrategy = taxFreeGoodsService.isTaxFreeGoods(name)
                    ? new TaxFree(dutyStrategy)
                    : new BasicTax(dutyStrategy);

            return new Order(new Item(name, price, taxStrategy), quantity);
        }

        throw new UnrecognizedCommandException();
    }
}

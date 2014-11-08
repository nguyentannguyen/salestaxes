package com.app.sale.shopping;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
@Component
public class ShoppingCart {

    public static final String NEW_LINE = System.getProperty("line.separator");

    List<Order> orders = new ArrayList<Order>();

    public List<Order> addOrder(Order order){
        orders.add(order);
        return orders;
    }

    public void clear(){
        orders.clear();
    }

    public BigDecimal taxAmount(){
        BigDecimal taxAmount = new BigDecimal(0.00);
        for(Order order : orders){
            taxAmount = taxAmount.add(order.tax());
        }
        return taxAmount;
    }

    public BigDecimal totalAmount(){
        BigDecimal totalAmount = new BigDecimal(0.00);
        for(Order order : orders){
            totalAmount = totalAmount.add(order.total());
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE).append("========= Invoice ========");
        for(Order order : orders){
            stringBuffer.append(NEW_LINE).append(order);
        }
        stringBuffer.append(NEW_LINE).append(String.format("Sales Taxes: %.2f", taxAmount()));
        stringBuffer.append(NEW_LINE).append(String.format("Total: %.2f", totalAmount()));

        return stringBuffer.toString();
    }
}

package com.app.sale.item;

import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by Nguyen Tan Nguyen < nguyenabap at gmail dot com > on 2014-11-06.
 */
@Service
public class TaxFreeGoodsService {
    static HashSet<String> taxFreeGoodsList = new HashSet<String>();

    public void addTaxFreeGoods(String goodsName){
        taxFreeGoodsList.add(goodsName.toLowerCase());
    }

    public boolean isTaxFreeGoods(String goodsName){
        for(String name : taxFreeGoodsList){
            if (name.contains(goodsName.toLowerCase()) || goodsName.toLowerCase().contains(name)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        taxFreeGoodsList.clear();
    }

    @Override
    public String toString(){
        return taxFreeGoodsList.toString();
    }

}

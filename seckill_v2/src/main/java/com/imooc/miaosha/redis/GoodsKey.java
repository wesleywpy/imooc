package com.imooc.miaosha.redis;

/**
 * @author Created by Wesley on 2018/6/20.
 */
public class GoodsKey extends BasePrefix {

    public static final GoodsKey GOODS_LIST = new GoodsKey(60, "goods_list");

    public static final GoodsKey GOODS_DETAIL = new GoodsKey(60, "goods_detail");

    public static final GoodsKey GOODS_STOCK = new GoodsKey(0, "goods_stock");

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

}

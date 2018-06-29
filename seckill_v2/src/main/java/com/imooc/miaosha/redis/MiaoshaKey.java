package com.imooc.miaosha.redis;

public class MiaoshaKey extends BasePrefix {

    public static final MiaoshaKey GOODS_OVER = new MiaoshaKey("go");

    private MiaoshaKey(String prefix) {
        super(prefix);
    }
}

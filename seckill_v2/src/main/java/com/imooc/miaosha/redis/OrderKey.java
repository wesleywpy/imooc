package com.imooc.miaosha.redis;

public class OrderKey extends BasePrefix {

    /**
     * 秒杀用户的Id和秒杀的商品Id
     */
    public static final OrderKey ORDER_MIAOSHA_UID_GID = new OrderKey("moug");

    private OrderKey(String prefix) {
        super(prefix);
    }

	public OrderKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
}

package com.imooc.miaosha.service;

import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.support.result.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.domain.OrderInfo;
import com.imooc.miaosha.support.vo.GoodsVo;

@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        // 减库存 下订单 写入秒杀订单
        int updateCount = goodsService.reduceStock(goods);
        if( updateCount < 1){
            throw new GlobalException(CodeMsg.MIAO_SHA_OVER);
        }
        // order_info maiosha_order
        return orderService.createOrder(user, goods);
    }

}

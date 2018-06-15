package com.imooc.miaosha.domain;

import java.util.Date;

import lombok.Data;

/**
 * 秒杀商品
 */
@Data
public class MiaoshaGoods {
    private Long id;

    private Long goodsId;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

}

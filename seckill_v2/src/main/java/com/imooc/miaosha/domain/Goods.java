package com.imooc.miaosha.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品
 */
@Data
@EqualsAndHashCode(of = "id")
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private String goodsDetail;

    private Double goodsPrice;

    private Integer goodsStock;
}

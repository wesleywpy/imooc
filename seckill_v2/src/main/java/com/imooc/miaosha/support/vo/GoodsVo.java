package com.imooc.miaosha.support.vo;

import java.util.Date;

import com.imooc.miaosha.domain.Goods;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsVo extends Goods {
    private Double miaoshaPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;
}

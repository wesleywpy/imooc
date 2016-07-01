package com.imooc.study.entity;

import java.util.Date;

/**
 * Created by Wesley on 2016/5/13.
 */
public class SuccessKilled {
    private Long seckillId;
    private Long userPhone;
    private Integer Sate;
    private Date createTime;

    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getSate() {
        return Sate;
    }

    public void setSate(Integer sate) {
        Sate = sate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.imooc.study.dto;

import com.imooc.study.entity.SuccessKilled;
import com.imooc.study.enums.SeckillStatEnum;

/**
 * 秒杀执行结果
 * Created by Wesley on 2016/5/21.
 */
public class SeckillExecution {

    private int state;

    /** 执行结果状态*/
    private long seckillId;

    private String stateInfo;

    private SuccessKilled successKilled;

    public SeckillExecution() {
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.state = statEnum.getState();
        this.seckillId = seckillId;
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}

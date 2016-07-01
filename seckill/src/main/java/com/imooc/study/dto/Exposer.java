package com.imooc.study.dto;

/**
 * 暴露秒杀地址
 * Created by Wesley on 2016/5/17.
 */
public class Exposer {
    /** 是否开启秒杀*/
    private boolean exposed;
    private long seckillId;
    private String signature;

    private long nowTime;
    private long startTime;
    private long endTime;

    public Exposer() {
    }

    public Exposer(long seckillId, boolean exposed) {
        this.seckillId = seckillId;
        this.exposed = exposed;
    }

    public Exposer(boolean exposed, long seckillId, String signature) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.signature = signature;
    }

    public Exposer(boolean exposed, long seckillId, long nowTime, long startTime, long endTime) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.nowTime = nowTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}

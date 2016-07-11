package com.imooc.study.service;

import com.imooc.study.dto.Exposer;
import com.imooc.study.dto.SeckillExecution;
import com.imooc.study.entity.Seckill;
import com.imooc.study.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度设计接口
 * 1.方法粒度 职责明确
 * 2.方法参数 参数简明
 * 3.方法抛出的异常
 * Created by Wesley on 2016/5/17.
 */
public interface SeckillService {

    /**
     * 查询所有秒杀
     * @return
     */
    List<Seckill> getSeckillList();


    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);


    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId 秒杀ID
     * @param userPhone 手机号
     * @param signature 摘要
     * @return
     * @throws SeckillException
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String signature) throws SeckillException;

    /**
     * 执行秒杀 通过存储过程
     * @throws SeckillException
     */
    SeckillException executeSeckillByProcedure(long seckillId, long userPhone, String signature) throws SeckillException;
}

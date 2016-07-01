package com.imooc.study.dao;

import com.imooc.study.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Wesley on 2016/5/13.
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细,可过滤重复(数据库有联合主键)
     *
     * @param seckilledId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckilledId") Long seckilledId, @Param("userPhone") Long userPhone);


    /**
     * 根据ID查询SuccessKilled并携带秒杀产品对象实体
     *
     * @param seckilledId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckilledId") Long seckilledId, @Param("userPhone") Long userPhone);
}

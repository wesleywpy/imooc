package com.imooc.study.dao;

import com.imooc.study.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Wesley on 2016/5/13.
 */
public interface SeckillDao {

        /**
         * 减库存
         *
         * @param seckillId
         * @param killTime
         * @return　如果更新行数大于1,表示更新的行数
         */
        int reduceNumber(@Param("seckillId") Long seckillId, @Param("killTime") Date killTime);


        /**
         * 根据ID查询秒杀对象
         *
         * @param seckillId
         * @return
         */
        Seckill queryById(long seckillId);


        /**
         * 根据偏移量查询秒杀商品列表
         *
         * @param offset
         * @param limit
         * @return
         */
        List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}

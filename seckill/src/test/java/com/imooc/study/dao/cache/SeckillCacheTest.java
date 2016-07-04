package com.imooc.study.dao.cache;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.imooc.study.dao.SeckillDao;
import com.imooc.study.entity.Seckill;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wesley on 2016/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillCacheTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void getSeckill() throws Exception {
        String key = "seckill:test";
        BoundValueOperations<String, Object> valueOps = redisTemplate.boundValueOps(key);
        System.out.println("valueOps.get() = " + valueOps.get());
    }

    @Test
    public void putSeckill() throws Exception {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        String key = "seckill:test1";
        BoundValueOperations<String, Object> valueOps = redisTemplate.boundValueOps(key);
        Seckill seckill = seckillDao.queryById(1001);
        valueOps.set(seckill, 60 * 60, TimeUnit.SECONDS);
    }

}
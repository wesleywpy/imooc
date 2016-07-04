package com.imooc.study.dao.cache;

import com.imooc.study.entity.Seckill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wesley on 2016/7/4.
 */
@Component
public class SeckillCache {
    private static final Log LOG = LogFactory.getLog(SeckillCache.class);

    private static final String KEY = "seckill:%s";
    private static final long TIMEOUT = 60 * 60;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Optional getSeckill(Long seckillId){
        String seckillKey = String.format(KEY, seckillId);
        if(!redisTemplate.hasKey(seckillKey)){
            return Optional.empty();
        }

        BoundValueOperations<String, Object> valueOperations = redisTemplate.boundValueOps(String.format(KEY, seckillId));
        return Optional.ofNullable(valueOperations.get());
    }

    /**
     * 缓存秒杀地址
     */
    public void putSeckill(Seckill seckill){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        BoundValueOperations<String, Object> valueOps = redisTemplate.boundValueOps(String.format(KEY, seckill.getId()));
        valueOps.set(seckill, TIMEOUT, TimeUnit.SECONDS);
    }
}

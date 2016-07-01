package com.imooc.study.dao;

import com.imooc.study.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.imooc.study.dao.SeckillDao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wesley on 2016/5/14.
 */
/**
 * 配置Spring和Junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    @Autowired
    SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2016, 5, 10, 15, 26);
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        assertEquals(1, seckillDao.reduceNumber(1002L, Date.from(instant)));
    }

    @Test
    public void testQueryById() throws Exception {
        Seckill seckill = seckillDao.queryById(1001);
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> list = seckillDao.queryAll(0,2);
        System.out.println(list);
    }
}
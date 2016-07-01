package com.imooc.study.dao;

import com.imooc.study.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Wesley on 2016/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

    @Autowired
    SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        assertEquals(1, successKilledDao.insertSuccessKilled(1002L, 15100012123L));
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        SuccessKilled sk = successKilledDao.queryByIdWithSeckill(1002L, 15100012123L);
        System.out.println(sk);
    }
}
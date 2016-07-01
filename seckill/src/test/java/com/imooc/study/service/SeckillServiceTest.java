package com.imooc.study.service;

import com.imooc.study.dto.SeckillExecution;
import com.imooc.study.entity.Seckill;
import com.imooc.study.exception.SeckillException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * //TODO: logback配置、秒杀多次测试
 * Created by Wesley on 2016/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        System.out.println(seckills);
    }

    @Test
    public void testGetById() throws Exception {
        Seckill  seckill = seckillService.getById(1002);
        System.out.println(seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long seckillId = 1001;
        long phone = 15108121224L;
        String md5 = "1234567asdf890zxcv";

        try{
            SeckillExecution execution =  seckillService.executeSeckill(seckillId, phone, md5);
            System.out.println(execution);
        }catch (SeckillException e){
            System.out.println("e = " + e);
        }
    }

    @Test
    public void testExecuteSeckill() throws Exception {

    }
}
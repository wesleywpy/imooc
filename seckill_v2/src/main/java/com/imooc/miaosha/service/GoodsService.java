package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.GoodsDao;
import com.imooc.miaosha.domain.MiaoshaGoods;
import com.imooc.miaosha.support.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    /**
     * @return 1 减库存成功, 小于1 减库存失败
     */
    public int reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        return goodsDao.reduceStock(g);
    }

}

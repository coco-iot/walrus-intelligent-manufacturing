package com.walrus.manufacturing.db.service;

import com.walrus.manufacturing.db.dao.ManufacturingOrderGoodsMapper;
import com.walrus.manufacturing.db.domain.ManufacturingOrderGoods;
import com.walrus.manufacturing.db.domain.ManufacturingOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingOrderGoodsService {
    @Resource
    private ManufacturingOrderGoodsMapper orderGoodsMapper;

    public int add(ManufacturingOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<ManufacturingOrderGoods> queryByOid(Integer orderId) {
        ManufacturingOrderGoodsExample example = new ManufacturingOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<ManufacturingOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        ManufacturingOrderGoodsExample example = new ManufacturingOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public ManufacturingOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(ManufacturingOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        ManufacturingOrderGoodsExample example = new ManufacturingOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        ManufacturingOrderGoodsExample example = new ManufacturingOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }

    public void deleteByOrderId(Integer orderId) {
        ManufacturingOrderGoodsExample example = new ManufacturingOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        orderGoodsMapper.logicalDeleteByExample(example);
    }
}

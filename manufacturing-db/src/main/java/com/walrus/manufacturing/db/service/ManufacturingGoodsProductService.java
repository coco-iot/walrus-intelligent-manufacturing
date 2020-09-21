package com.walrus.manufacturing.db.service;

import com.walrus.manufacturing.db.dao.GoodsProductMapper;
import com.walrus.manufacturing.db.dao.ManufacturingGoodsProductMapper;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsProduct;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingGoodsProductService {
    @Resource
    private ManufacturingGoodsProductMapper manufacturingGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<ManufacturingGoodsProduct> queryByGid(Integer gid) {
        ManufacturingGoodsProductExample example = new ManufacturingGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return manufacturingGoodsProductMapper.selectByExample(example);
    }

    public ManufacturingGoodsProduct findById(Integer id) {
        return manufacturingGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        manufacturingGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        manufacturingGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        ManufacturingGoodsProductExample example = new ManufacturingGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) manufacturingGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        ManufacturingGoodsProductExample example = new ManufacturingGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        manufacturingGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(ManufacturingGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        manufacturingGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}
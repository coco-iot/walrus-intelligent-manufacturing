package com.walrus.manufacturing.db.service;

import com.walrus.manufacturing.db.dao.ManufacturingGoodsAttributeMapper;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsAttribute;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingGoodsAttributeService {
    @Resource
    private ManufacturingGoodsAttributeMapper goodsAttributeMapper;

    public List<ManufacturingGoodsAttribute> queryByGid(Integer goodsId) {
        ManufacturingGoodsAttributeExample example = new ManufacturingGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(ManufacturingGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public ManufacturingGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        ManufacturingGoodsAttributeExample example = new ManufacturingGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(ManufacturingGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}

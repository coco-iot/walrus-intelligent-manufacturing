package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingFootprintMapper;
import com.walrus.manufacturing.db.domain.ManufacturingFootprint;
import com.walrus.manufacturing.db.domain.ManufacturingFootprintExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingFootprintService {
    @Resource
    private ManufacturingFootprintMapper footprintMapper;

    public List<ManufacturingFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        ManufacturingFootprintExample example = new ManufacturingFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(ManufacturingFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public ManufacturingFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public ManufacturingFootprint findById(Integer userId, Integer id) {
        ManufacturingFootprintExample example = new ManufacturingFootprintExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return footprintMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<ManufacturingFootprint> querySelective(String userId, String goodsId, Integer page, Integer size, String sort, String order) {
        ManufacturingFootprintExample example = new ManufacturingFootprintExample();
        ManufacturingFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }
}

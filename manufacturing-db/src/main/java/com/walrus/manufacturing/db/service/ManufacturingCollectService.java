package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingCollectMapper;
import com.walrus.manufacturing.db.domain.ManufacturingCollect;
import com.walrus.manufacturing.db.domain.ManufacturingCollectExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingCollectService {
    @Resource
    private ManufacturingCollectMapper collectMapper;

    public int count(int uid, Integer gid) {
        ManufacturingCollectExample example = new ManufacturingCollectExample();
        example.or().andUserIdEqualTo(uid).andValueIdEqualTo(gid).andDeletedEqualTo(false);
        return (int) collectMapper.countByExample(example);
    }

    public List<ManufacturingCollect> queryByType(Integer userId, Byte type, Integer page, Integer limit, String sort, String order) {
        ManufacturingCollectExample example = new ManufacturingCollectExample();
        ManufacturingCollectExample.Criteria criteria = example.createCriteria();

        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        criteria.andUserIdEqualTo(userId);
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return collectMapper.selectByExample(example);
    }

    public int countByType(Integer userId, Byte type) {
        ManufacturingCollectExample example = new ManufacturingCollectExample();
        example.or().andUserIdEqualTo(userId).andTypeEqualTo(type).andDeletedEqualTo(false);
        return (int) collectMapper.countByExample(example);
    }

    public ManufacturingCollect queryByTypeAndValue(Integer userId, Byte type, Integer valueId) {
        ManufacturingCollectExample example = new ManufacturingCollectExample();
        example.or().andUserIdEqualTo(userId).andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        return collectMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        collectMapper.logicalDeleteByPrimaryKey(id);
    }

    public int add(ManufacturingCollect collect) {
        collect.setAddTime(LocalDateTime.now());
        collect.setUpdateTime(LocalDateTime.now());
        return collectMapper.insertSelective(collect);
    }

    public List<ManufacturingCollect> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        ManufacturingCollectExample example = new ManufacturingCollectExample();
        ManufacturingCollectExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return collectMapper.selectByExample(example);
    }
}

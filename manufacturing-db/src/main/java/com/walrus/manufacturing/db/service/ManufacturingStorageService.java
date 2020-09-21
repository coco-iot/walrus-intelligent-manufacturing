package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingStorageMapper;
import com.walrus.manufacturing.db.domain.ManufacturingStorage;
import com.walrus.manufacturing.db.domain.ManufacturingStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingStorageService {
    @Autowired
    private ManufacturingStorageMapper storageMapper;

    public void deleteByKey(String key) {
        ManufacturingStorageExample example = new ManufacturingStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(ManufacturingStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public ManufacturingStorage findByKey(String key) {
        ManufacturingStorageExample example = new ManufacturingStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(ManufacturingStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public ManufacturingStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<ManufacturingStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        ManufacturingStorageExample example = new ManufacturingStorageExample();
        ManufacturingStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}

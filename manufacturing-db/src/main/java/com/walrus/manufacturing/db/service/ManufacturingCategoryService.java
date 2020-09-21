package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingCategoryMapper;
import com.walrus.manufacturing.db.domain.ManufacturingCategory;
import com.walrus.manufacturing.db.domain.ManufacturingCategoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingCategoryService {
    @Resource
    private ManufacturingCategoryMapper categoryMapper;
    private ManufacturingCategory.Column[] CHANNEL = {ManufacturingCategory.Column.id, ManufacturingCategory.Column.name, ManufacturingCategory.Column.iconUrl};

    public List<ManufacturingCategory> queryL1WithoutRecommend(int offset, int limit) {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<ManufacturingCategory> queryL1(int offset, int limit) {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<ManufacturingCategory> queryL1() {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<ManufacturingCategory> queryByPid(Integer pid) {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<ManufacturingCategory> queryL2ByIds(List<Integer> ids) {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public ManufacturingCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<ManufacturingCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        ManufacturingCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(ManufacturingCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<ManufacturingCategory> queryChannel() {
        ManufacturingCategoryExample example = new ManufacturingCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}

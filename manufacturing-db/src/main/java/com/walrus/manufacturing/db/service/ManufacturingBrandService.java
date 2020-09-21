package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingBrandMapper;
import com.walrus.manufacturing.db.domain.ManufacturingBrand;
import com.walrus.manufacturing.db.domain.ManufacturingBrand.Column;
import com.walrus.manufacturing.db.domain.ManufacturingBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingBrandService {
    @Resource
    private ManufacturingBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<ManufacturingBrand> query(Integer page, Integer limit, String sort, String order) {
        ManufacturingBrandExample example = new ManufacturingBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<ManufacturingBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public ManufacturingBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<ManufacturingBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        ManufacturingBrandExample example = new ManufacturingBrandExample();
        ManufacturingBrandExample.Criteria criteria = example.createCriteria();

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
        return brandMapper.selectByExample(example);
    }

    public int updateById(ManufacturingBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<ManufacturingBrand> all() {
        ManufacturingBrandExample example = new ManufacturingBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}

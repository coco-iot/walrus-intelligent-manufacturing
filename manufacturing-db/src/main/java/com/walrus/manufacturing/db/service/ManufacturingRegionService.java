package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingRegionMapper;
import com.walrus.manufacturing.db.domain.ManufacturingRegion;
import com.walrus.manufacturing.db.domain.ManufacturingRegionExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManufacturingRegionService {

    @Resource
    private ManufacturingRegionMapper regionMapper;

    public List<ManufacturingRegion> getAll(){
        ManufacturingRegionExample example = new ManufacturingRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<ManufacturingRegion> queryByPid(Integer parentId) {
        ManufacturingRegionExample example = new ManufacturingRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public ManufacturingRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<ManufacturingRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        ManufacturingRegionExample example = new ManufacturingRegionExample();
        ManufacturingRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}

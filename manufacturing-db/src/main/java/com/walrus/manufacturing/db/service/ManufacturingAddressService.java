package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingAddressMapper;
import com.walrus.manufacturing.db.domain.ManufacturingAddress;
import com.walrus.manufacturing.db.domain.ManufacturingAddressExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingAddressService {
    @Resource
    private ManufacturingAddressMapper addressMapper;

    public List<ManufacturingAddress> queryByUid(Integer uid) {
        ManufacturingAddressExample example = new ManufacturingAddressExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public ManufacturingAddress query(Integer userId, Integer id) {
        ManufacturingAddressExample example = new ManufacturingAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public int add(ManufacturingAddress address) {
        address.setAddTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.insertSelective(address);
    }

    public int update(ManufacturingAddress address) {
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public ManufacturingAddress findDefault(Integer userId) {
        ManufacturingAddressExample example = new ManufacturingAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public void resetDefault(Integer userId) {
        ManufacturingAddress address = new ManufacturingAddress();
        address.setIsDefault(false);
        address.setUpdateTime(LocalDateTime.now());
        ManufacturingAddressExample example = new ManufacturingAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public List<ManufacturingAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        ManufacturingAddressExample example = new ManufacturingAddressExample();
        ManufacturingAddressExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return addressMapper.selectByExample(example);
    }
}

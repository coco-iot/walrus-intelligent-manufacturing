package com.walrus.manufacturing.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingRoleMapper;
import com.walrus.manufacturing.db.domain.ManufacturingRole;
import com.walrus.manufacturing.db.domain.ManufacturingRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ManufacturingRoleService {
    @Resource
    private ManufacturingRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        ManufacturingRoleExample example = new ManufacturingRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<ManufacturingRole> roleList = roleMapper.selectByExample(example);

        for(ManufacturingRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<ManufacturingRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        ManufacturingRoleExample example = new ManufacturingRoleExample();
        ManufacturingRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public ManufacturingRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(ManufacturingRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(ManufacturingRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        ManufacturingRoleExample example = new ManufacturingRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<ManufacturingRole> queryAll() {
        ManufacturingRoleExample example = new ManufacturingRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}

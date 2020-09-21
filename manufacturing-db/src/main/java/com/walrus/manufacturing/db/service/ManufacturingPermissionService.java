package com.walrus.manufacturing.db.service;

import com.walrus.manufacturing.db.dao.ManufacturingPermissionMapper;
import com.walrus.manufacturing.db.domain.ManufacturingPermission;
import com.walrus.manufacturing.db.domain.ManufacturingPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ManufacturingPermissionService {
    @Resource
    private ManufacturingPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if(roleIds.length == 0){
            return permissions;
        }

        ManufacturingPermissionExample example = new ManufacturingPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<ManufacturingPermission> permissionList = permissionMapper.selectByExample(example);

        for(ManufacturingPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }


    public Set<String> queryByRoleId(Integer roleId) {
        Set<String> permissions = new HashSet<String>();
        if(roleId == null){
            return permissions;
        }

        ManufacturingPermissionExample example = new ManufacturingPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        List<ManufacturingPermission> permissionList = permissionMapper.selectByExample(example);

        for(ManufacturingPermission permission : permissionList){
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

    public boolean checkSuperPermission(Integer roleId) {
        if(roleId == null){
            return false;
        }

        ManufacturingPermissionExample example = new ManufacturingPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andPermissionEqualTo("*").andDeletedEqualTo(false);
        return permissionMapper.countByExample(example) != 0;
    }

    public void deleteByRoleId(Integer roleId) {
        ManufacturingPermissionExample example = new ManufacturingPermissionExample();
        example.or().andRoleIdEqualTo(roleId).andDeletedEqualTo(false);
        permissionMapper.logicalDeleteByExample(example);
    }

    public void add(ManufacturingPermission manufacturingPermission) {
        manufacturingPermission.setAddTime(LocalDateTime.now());
        manufacturingPermission.setUpdateTime(LocalDateTime.now());
        permissionMapper.insertSelective(manufacturingPermission);
    }
}

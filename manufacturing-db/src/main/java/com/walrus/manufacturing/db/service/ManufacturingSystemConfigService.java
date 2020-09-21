package com.walrus.manufacturing.db.service;

import com.walrus.manufacturing.db.dao.ManufacturingSystemMapper;
import com.walrus.manufacturing.db.domain.ManufacturingSystem;
import com.walrus.manufacturing.db.domain.ManufacturingSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufacturingSystemConfigService {
    @Resource
    private ManufacturingSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        ManufacturingSystemExample example = new ManufacturingSystemExample();
        example.or().andDeletedEqualTo(false);

        List<ManufacturingSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (ManufacturingSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        ManufacturingSystemExample example = new ManufacturingSystemExample();
        example.or().andKeyNameLike("manufacturing_mall_%").andDeletedEqualTo(false);
        List<ManufacturingSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(ManufacturingSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        ManufacturingSystemExample example = new ManufacturingSystemExample();
        example.or().andKeyNameLike("manufacturing_wx_%").andDeletedEqualTo(false);
        List<ManufacturingSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(ManufacturingSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        ManufacturingSystemExample example = new ManufacturingSystemExample();
        example.or().andKeyNameLike("manufacturing_order_%").andDeletedEqualTo(false);
        List<ManufacturingSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(ManufacturingSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        ManufacturingSystemExample example = new ManufacturingSystemExample();
        example.or().andKeyNameLike("manufacturing_express_%").andDeletedEqualTo(false);
        List<ManufacturingSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(ManufacturingSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            ManufacturingSystemExample example = new ManufacturingSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            ManufacturingSystem system = new ManufacturingSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        ManufacturingSystem system = new ManufacturingSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}

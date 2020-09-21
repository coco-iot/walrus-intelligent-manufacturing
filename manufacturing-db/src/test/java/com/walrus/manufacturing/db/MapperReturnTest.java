package com.walrus.manufacturing.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.walrus.manufacturing.db.dao.ManufacturingSystemMapper;
import com.walrus.manufacturing.db.domain.ManufacturingSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperReturnTest {

    @Autowired
    private ManufacturingSystemMapper systemMapper;

    @Test
    public void test() {
        ManufacturingSystem system = new ManufacturingSystem();
        system.setKeyName("test-system-key");
        system.setKeyValue("test-system-value");
        int updates = systemMapper.insertSelective(system);
        Assert.assertEquals(updates, 1);

        updates = systemMapper.deleteByPrimaryKey(system.getId());
        Assert.assertEquals(updates, 1);

        updates = systemMapper.updateByPrimaryKey(system);
        Assert.assertEquals(updates, 0);
    }

}


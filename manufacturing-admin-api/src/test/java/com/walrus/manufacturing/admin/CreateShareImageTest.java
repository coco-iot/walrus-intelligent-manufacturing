package com.walrus.manufacturing.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.walrus.manufacturing.core.qcode.QCodeService;
import com.walrus.manufacturing.db.domain.ManufacturingGoods;
import com.walrus.manufacturing.db.service.ManufacturingGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateShareImageTest {
    @Autowired
    QCodeService qCodeService;
    @Autowired
    ManufacturingGoodsService manufacturingGoodsService;

    @Test
    public void test() {
        ManufacturingGoods good = manufacturingGoodsService.findById(1181010);
        qCodeService.createGoodShareImage(good.getId().toString(), good.getPicUrl(), good.getName());
    }
}

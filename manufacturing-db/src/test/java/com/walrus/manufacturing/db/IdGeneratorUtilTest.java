package com.walrus.manufacturing.db;

import com.walrus.manufacturing.db.util.IdGeneratorUtil;
import org.junit.Test;

public class IdGeneratorUtilTest {
    @Test
    public void test() {
        System.out.println(IdGeneratorUtil.getLongGuid());
    }
}

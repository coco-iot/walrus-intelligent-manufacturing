package com.walrus.manufacturing.db;

import org.junit.Test;
import com.walrus.manufacturing.db.util.DbUtil;

import java.io.File;

public class DbUtilTest {
    @Test
    public void testBackup() {
        File file = new File("test.sql");
        DbUtil.backup(file, "manufacturing", "manufacturing123456", "manufacturing");
    }

//    这个测试用例会重置manufacturing数据库，所以比较危险，请开发者注意
//    @Test
    public void testLoad() {
        File file = new File("test.sql");
        DbUtil.load(file, "manufacturing", "manufacturing123456", "manufacturing");
    }
}

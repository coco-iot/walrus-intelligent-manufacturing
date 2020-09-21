package com.walrus.manufacturing.wx;

import com.walrus.manufacturing.core.util.JacksonUtil;
import com.walrus.manufacturing.db.domain.RideOrderKvPo;
import org.junit.Test;

public class JacksonUtilTest {
    @Test
    public void test() {
        String data = "{\"cancelOrderAmount\":\"0\"}";
        RideOrderKvPo.SNAP_CANCEL snap = null;
        snap = JacksonUtil.parseObject(data, RideOrderKvPo.SNAP_CANCEL.class);
        if(snap != null) {
            System.out.println(snap.getCancelOrderAmount());
        }
    }
}

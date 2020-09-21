package com.walrus.manufacturing.wx.service;

import com.walrus.manufacturing.core.util.ResponseUtil;
import com.walrus.manufacturing.wx.dto.AvailableService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufacturingToftService {
    private final Log logger = LogFactory.getLog(ManufacturingToftService.class);

    public Object getAvailableService() {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, AvailableService> service = new HashMap<>();
        AvailableService availableService = new AvailableService();
        availableService.setCity_short("bj");
        availableService.setEn("beijing");
        availableService.setIs_oversea(0);
        availableService.setName("北京");
        AvailableService.Position position = new AvailableService.Position();
        position.setLat(39.955538);
        position.setLng(116.458637);
        availableService.setPosition(position);
        service.put("bj", availableService);
        result.put("cityList", service);
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        //获取时间戳
        String time = dateFormat.format(now);
        result.put("version", time);
        return ResponseUtil.ok(result);
    }
}

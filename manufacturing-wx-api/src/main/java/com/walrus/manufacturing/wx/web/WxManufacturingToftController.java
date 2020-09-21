package com.walrus.manufacturing.wx.web;

import com.walrus.manufacturing.wx.service.ManufacturingToftService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manufacturing服务
 */
@RestController
@RequestMapping("/wx/manufacturingtoft")
@Validated
public class WxManufacturingToftController {
    private final Log logger = LogFactory.getLog(WxManufacturingToftController.class);

    @Autowired
    private ManufacturingToftService manufacturingToftService;

    /**
     * 获取可用服务
     *
     * @return 可用服务数据
     */
    @GetMapping("getAvailableService")
    public Object getAvailableService() {
        return manufacturingToftService.getAvailableService();
    }
}

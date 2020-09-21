package com.walrus.manufacturing.wx.service;

import com.walrus.manufacturing.db.domain.ManufacturingUser;
import com.walrus.manufacturing.db.service.ManufacturingUserService;
import com.walrus.manufacturing.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private ManufacturingUserService userService;


    public UserInfo getInfo(Integer userId) {
        ManufacturingUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}

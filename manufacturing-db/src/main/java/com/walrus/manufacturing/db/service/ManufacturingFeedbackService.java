package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingFeedbackMapper;
import com.walrus.manufacturing.db.domain.ManufacturingFeedback;
import com.walrus.manufacturing.db.domain.ManufacturingFeedbackExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Peter
 * @date 2018/8/27 11:39
 */
@Service
public class ManufacturingFeedbackService {
    @Autowired
    private ManufacturingFeedbackMapper feedbackMapper;

    public Integer add(ManufacturingFeedback feedback) {
        feedback.setAddTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<ManufacturingFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        ManufacturingFeedbackExample example = new ManufacturingFeedbackExample();
        ManufacturingFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}

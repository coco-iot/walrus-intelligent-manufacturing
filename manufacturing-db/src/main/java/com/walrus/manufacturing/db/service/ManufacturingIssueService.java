package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingIssueMapper;
import com.walrus.manufacturing.db.domain.ManufacturingIssue;
import com.walrus.manufacturing.db.domain.ManufacturingIssueExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingIssueService {
    @Resource
    private ManufacturingIssueMapper issueMapper;

    public void deleteById(Integer id) {
        issueMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingIssue issue) {
        issue.setAddTime(LocalDateTime.now());
        issue.setUpdateTime(LocalDateTime.now());
        issueMapper.insertSelective(issue);
    }

    public List<ManufacturingIssue> querySelective(String question, Integer page, Integer limit, String sort, String order) {
        ManufacturingIssueExample example = new ManufacturingIssueExample();
        ManufacturingIssueExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(question)) {
            criteria.andQuestionLike("%" + question + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return issueMapper.selectByExample(example);
    }

    public int updateById(ManufacturingIssue issue) {
        issue.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateByPrimaryKeySelective(issue);
    }

    public ManufacturingIssue findById(Integer id) {
        return issueMapper.selectByPrimaryKey(id);
    }
}

package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingSearchHistoryMapper;
import com.walrus.manufacturing.db.domain.ManufacturingSearchHistory;
import com.walrus.manufacturing.db.domain.ManufacturingSearchHistoryExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingSearchHistoryService {
    @Resource
    private ManufacturingSearchHistoryMapper searchHistoryMapper;

    public void save(ManufacturingSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<ManufacturingSearchHistory> queryByUid(int uid) {
        ManufacturingSearchHistoryExample example = new ManufacturingSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, ManufacturingSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        ManufacturingSearchHistoryExample example = new ManufacturingSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<ManufacturingSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        ManufacturingSearchHistoryExample example = new ManufacturingSearchHistoryExample();
        ManufacturingSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}

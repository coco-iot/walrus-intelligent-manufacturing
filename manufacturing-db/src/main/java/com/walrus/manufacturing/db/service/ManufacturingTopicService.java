package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingTopicMapper;
import com.walrus.manufacturing.db.domain.ManufacturingGroupon;
import com.walrus.manufacturing.db.domain.ManufacturingTopic;
import com.walrus.manufacturing.db.domain.ManufacturingTopic.Column;
import com.walrus.manufacturing.db.domain.ManufacturingTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingTopicService {
    @Resource
    private ManufacturingTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<ManufacturingTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<ManufacturingTopic> queryList(int offset, int limit, String sort, String order) {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public ManufacturingTopic findById(Integer id) {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<ManufacturingTopic> queryRelatedList(Integer id, int offset, int limit) {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<ManufacturingTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        ManufacturingTopic topic = topics.get(0);

        example = new ManufacturingTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<ManufacturingTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<ManufacturingTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        ManufacturingTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(ManufacturingTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(ManufacturingTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


    public void deleteByIds(List<Integer> ids) {
        ManufacturingTopicExample example = new ManufacturingTopicExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        ManufacturingTopic topic = new ManufacturingTopic();
        topic.setUpdateTime(LocalDateTime.now());
        topic.setDeleted(true);
        topicMapper.updateByExampleSelective(topic, example);
    }
}

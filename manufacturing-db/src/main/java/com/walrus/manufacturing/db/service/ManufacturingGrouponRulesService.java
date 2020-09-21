package com.walrus.manufacturing.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingGoodsMapper;
import com.walrus.manufacturing.db.dao.ManufacturingGrouponRulesMapper;
import com.walrus.manufacturing.db.domain.ManufacturingGoods;
import com.walrus.manufacturing.db.domain.ManufacturingGrouponRules;
import com.walrus.manufacturing.db.domain.ManufacturingGrouponRulesExample;
import com.walrus.manufacturing.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingGrouponRulesService {
    @Resource
    private ManufacturingGrouponRulesMapper mapper;
    @Resource
    private ManufacturingGoodsMapper goodsMapper;
    private ManufacturingGoods.Column[] goodsColumns = new ManufacturingGoods.Column[]{ManufacturingGoods.Column.id, ManufacturingGoods.Column.name, ManufacturingGoods.Column.brief, ManufacturingGoods.Column.picUrl, ManufacturingGoods.Column.counterPrice, ManufacturingGoods.Column.retailPrice};

    public int createRules(ManufacturingGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public ManufacturingGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<ManufacturingGrouponRules> queryByGoodsId(Integer goodsId) {
        ManufacturingGrouponRulesExample example = new ManufacturingGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        ManufacturingGrouponRulesExample example = new ManufacturingGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<ManufacturingGrouponRules> queryByStatus(Short status) {
        ManufacturingGrouponRulesExample example = new ManufacturingGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<ManufacturingGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<ManufacturingGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        ManufacturingGrouponRulesExample example = new ManufacturingGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(ManufacturingGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<ManufacturingGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        ManufacturingGrouponRulesExample example = new ManufacturingGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        ManufacturingGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(ManufacturingGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}
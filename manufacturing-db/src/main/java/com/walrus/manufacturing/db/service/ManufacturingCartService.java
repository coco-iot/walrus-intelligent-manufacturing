package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingCartMapper;
import com.walrus.manufacturing.db.domain.ManufacturingCart;
import com.walrus.manufacturing.db.domain.ManufacturingCartExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ManufacturingCartService {
    @Resource
    private ManufacturingCartMapper cartMapper;

    public ManufacturingCart queryExist(Integer goodsId, Integer productId, Integer userId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andGoodsIdEqualTo(goodsId).andProductIdEqualTo(productId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return cartMapper.selectOneByExample(example);
    }

    public void add(ManufacturingCart cart) {
        cart.setAddTime(LocalDateTime.now());
        cart.setUpdateTime(LocalDateTime.now());
        cartMapper.insertSelective(cart);
    }

    public int updateById(ManufacturingCart cart) {
        cart.setUpdateTime(LocalDateTime.now());
        return cartMapper.updateByPrimaryKeySelective(cart);
    }

    public List<ManufacturingCart> queryByUid(int userId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return cartMapper.selectByExample(example);
    }


    public List<ManufacturingCart> queryByUidAndChecked(Integer userId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andCheckedEqualTo(true).andDeletedEqualTo(false);
        return cartMapper.selectByExample(example);
    }

    public int delete(List<Integer> productIdList, int userId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andProductIdIn(productIdList);
        return cartMapper.logicalDeleteByExample(example);
    }

    public ManufacturingCart findById(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    public ManufacturingCart findById(Integer userId, Integer id) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andIdEqualTo(id).andDeletedEqualTo(false);
        return cartMapper.selectOneByExample(example);
    }

    public int updateCheck(Integer userId, List<Integer> idsList, Boolean checked) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andProductIdIn(idsList).andDeletedEqualTo(false);
        ManufacturingCart cart = new ManufacturingCart();
        cart.setChecked(checked);
        cart.setUpdateTime(LocalDateTime.now());
        return cartMapper.updateByExampleSelective(cart, example);
    }

    public void clearGoods(Integer userId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andUserIdEqualTo(userId).andCheckedEqualTo(true);
        ManufacturingCart cart = new ManufacturingCart();
        cart.setDeleted(true);
        cartMapper.updateByExampleSelective(cart, example);
    }

    public List<ManufacturingCart> querySelective(Integer userId, Integer goodsId, Integer page, Integer limit, String sort, String order) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        ManufacturingCartExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(goodsId);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return cartMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        cartMapper.logicalDeleteByPrimaryKey(id);
    }

    public boolean checkExist(Integer goodsId) {
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andGoodsIdEqualTo(goodsId).andCheckedEqualTo(true).andDeletedEqualTo(false);
        return cartMapper.countByExample(example) != 0;
    }

    public void updateProduct(Integer id, String goodsSn, String goodsName, BigDecimal price, String url) {
        ManufacturingCart cart = new ManufacturingCart();
        cart.setPrice(price);
        cart.setPicUrl(url);
        cart.setGoodsSn(goodsSn);
        cart.setGoodsName(goodsName);
        ManufacturingCartExample example = new ManufacturingCartExample();
        example.or().andProductIdEqualTo(id);
        cartMapper.updateByExampleSelective(cart, example);
    }
}

package com.walrus.manufacturing.db.service;

import com.github.pagehelper.PageHelper;
import com.walrus.manufacturing.db.dao.ManufacturingOrderMapper;
import com.walrus.manufacturing.db.dao.OrderMapper;
import com.walrus.manufacturing.db.domain.ManufacturingOrder;
import com.walrus.manufacturing.db.domain.ManufacturingOrderExample;
import com.walrus.manufacturing.db.util.OrderUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ManufacturingOrderService {
    @Resource
    private ManufacturingOrderMapper manufacturingOrderMapper;
    @Resource
    private OrderMapper orderMapper;

    public int add(ManufacturingOrder order) {
        order.setAddTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return manufacturingOrderMapper.insertSelective(order);
    }

    public int count(Integer userId) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return (int) manufacturingOrderMapper.countByExample(example);
    }

    public ManufacturingOrder findById(Integer orderId) {
        return manufacturingOrderMapper.selectByPrimaryKey(orderId);
    }

    public ManufacturingOrder findById(Integer userId, Integer orderId) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andIdEqualTo(orderId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return manufacturingOrderMapper.selectOneByExample(example);
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public int countByOrderSn(Integer userId, String orderSn) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return (int) manufacturingOrderMapper.countByExample(example);
    }

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        while (countByOrderSn(userId, orderSn) != 0) {
            orderSn = now + getRandomNum(6);
        }
        return orderSn;
    }

    public List<ManufacturingOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus, Integer page, Integer limit, String sort, String order) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.setOrderByClause(ManufacturingOrder.Column.addTime.desc());
        ManufacturingOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if (orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return manufacturingOrderMapper.selectByExample(example);
    }

    public List<ManufacturingOrder> querySelective(Integer userId, String orderSn, LocalDateTime start, LocalDateTime end, List<Short> orderStatusArray, Integer page, Integer limit, String sort, String order) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        ManufacturingOrderExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if(start != null){
            criteria.andAddTimeGreaterThanOrEqualTo(start);
        }
        if(end != null){
            criteria.andAddTimeLessThanOrEqualTo(end);
        }
        if (orderStatusArray != null && orderStatusArray.size() != 0) {
            criteria.andOrderStatusIn(orderStatusArray);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return manufacturingOrderMapper.selectByExample(example);
    }

    public int updateWithOptimisticLocker(ManufacturingOrder order) {
        LocalDateTime preUpdateTime = order.getUpdateTime();
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
    }

    public void deleteById(Integer id) {
        manufacturingOrderMapper.logicalDeleteByPrimaryKey(id);
    }

    public int count() {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andDeletedEqualTo(false);
        return (int) manufacturingOrderMapper.countByExample(example);
    }

    public List<ManufacturingOrder> queryUnpaid(int minutes) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_CREATE).andDeletedEqualTo(false);
        return manufacturingOrderMapper.selectByExample(example);
    }

    public List<ManufacturingOrder> queryUnconfirm(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_SHIP).andShipTimeLessThan(expired).andDeletedEqualTo(false);
        return manufacturingOrderMapper.selectByExample(example);
    }

    public ManufacturingOrder findBySn(String orderSn) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return manufacturingOrderMapper.selectOneByExample(example);
    }

    public Map<Object, Object> orderInfo(Integer userId) {
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        List<ManufacturingOrder> orders = manufacturingOrderMapper.selectByExampleSelective(example, ManufacturingOrder.Column.orderStatus, ManufacturingOrder.Column.comments);

        int unpaid = 0;
        int unship = 0;
        int unrecv = 0;
        int uncomment = 0;
        for (ManufacturingOrder order : orders) {
            if (OrderUtil.isCreateStatus(order)) {
                unpaid++;
            } else if (OrderUtil.isPayStatus(order)) {
                unship++;
            } else if (OrderUtil.isShipStatus(order)) {
                unrecv++;
            } else if (OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)) {
                uncomment += order.getComments();
            } else {
                // do nothing
            }
        }

        Map<Object, Object> orderInfo = new HashMap<Object, Object>();
        orderInfo.put("unpaid", unpaid);
        orderInfo.put("unship", unship);
        orderInfo.put("unrecv", unrecv);
        orderInfo.put("uncomment", uncomment);
        return orderInfo;

    }

    public List<ManufacturingOrder> queryComment(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        ManufacturingOrderExample example = new ManufacturingOrderExample();
        example.or().andCommentsGreaterThan((short) 0).andConfirmTimeLessThan(expired).andDeletedEqualTo(false);
        return manufacturingOrderMapper.selectByExample(example);
    }

    public void updateAftersaleStatus(Integer orderId, Short statusReject) {
        ManufacturingOrder order = new ManufacturingOrder();
        order.setId(orderId);
        order.setAftersaleStatus(statusReject);
        order.setUpdateTime(LocalDateTime.now());
        manufacturingOrderMapper.updateByPrimaryKeySelective(order);
    }
}

package com.walrus.manufacturing.db.dao;

import org.apache.ibatis.annotations.Param;
import com.walrus.manufacturing.db.domain.ManufacturingOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") ManufacturingOrder order);
}
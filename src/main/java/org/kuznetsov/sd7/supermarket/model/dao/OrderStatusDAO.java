package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderStatus;

import java.util.List;

public interface OrderStatusDAO {
    List<OrderStatus> getAllOrderStatuses();
    int getIdOrderStatusByValue(String orderStatus);
}

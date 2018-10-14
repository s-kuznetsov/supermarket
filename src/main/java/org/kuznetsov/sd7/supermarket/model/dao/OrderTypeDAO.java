package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;

import java.util.List;

public interface OrderTypeDAO {
    List<OrderType> getAllOrderTypes();
    int getIdOrderTypeByValue(String orderType);
    void deleteOrderTypeById(long idOrderType);
    OrderType getOrderTypeById(long idOrderType);
    void editOrderType(OrderType orderType);
    void insertOrderType(OrderType orderType);
    OrderType findProductByName(String orderType);
}

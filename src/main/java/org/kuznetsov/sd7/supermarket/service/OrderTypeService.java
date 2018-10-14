package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;

import java.util.List;

public interface OrderTypeService {
    List<OrderType> getAllProducts();
    void deleteProductById(long idOrderType);
    OrderType getOrderTypeById(long idOrderType);
    void editProduct(OrderType orderType);
    void addProduct(OrderType orderType);
    OrderType findProductByName(String orderType);
}

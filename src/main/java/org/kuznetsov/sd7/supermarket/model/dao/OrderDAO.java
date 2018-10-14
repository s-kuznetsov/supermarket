package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.exceptions.CustomException;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();
    List<Order> getAllOrdersOfThisClient(Client client);
    void insertOrder(Order order);
    void deleteOrder(Order order);
    void deleteOrderById(long idOrder);
    void updateOrder(Order order);
}

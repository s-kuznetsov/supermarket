package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<Order> getOrdersOfClient(Client client);
    void addOrder(Order order);
    void deleteOrderById(long idOrder);
}

package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.dao.OrderDAO;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public List<Order> getOrdersOfClient(Client client) {
        return orderDAO.getAllOrdersOfThisClient(client);
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.insertOrder(order);
    }

    @Override
    public void deleteOrderById(long idOrder) {
        orderDAO.deleteOrderById(idOrder);
    }
}

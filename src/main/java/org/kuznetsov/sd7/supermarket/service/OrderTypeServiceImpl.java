package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.dao.OrderTypeDAO;
import org.kuznetsov.sd7.supermarket.model.dao.OrderTypeDAOImpl;
import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTypeServiceImpl implements OrderTypeService {

    private OrderTypeDAO orderTypeDAO;

    @Autowired
    public void setOrderTypeDAO(OrderTypeDAO orderTypeDAO) {
        this.orderTypeDAO = orderTypeDAO;
    }

    @Override
    public List<OrderType> getAllProducts() {
        return orderTypeDAO.getAllOrderTypes();
    }

    @Override
    public void deleteProductById(long idOrderType) {
        orderTypeDAO.deleteOrderTypeById(idOrderType);
    }

    @Override
    public OrderType getOrderTypeById(long idOrderType) {
        return orderTypeDAO.getOrderTypeById(idOrderType);
    }

    @Override
    public void editProduct(OrderType orderType) {
        orderTypeDAO.editOrderType(orderType);
    }

    @Override
    public void addProduct(OrderType orderType) {
        orderTypeDAO.insertOrderType(orderType);
    }

    @Override
    public OrderType findProductByName(String orderType) {
        return orderTypeDAO.findProductByName(orderType);
    }
}

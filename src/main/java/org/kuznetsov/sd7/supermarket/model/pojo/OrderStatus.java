package org.kuznetsov.sd7.supermarket.model.pojo;

public class OrderStatus {
    private int idOrderStatus;
    private String orderStatus;

    public OrderStatus() {
    }

    public OrderStatus(int idOrderStatus, String orderStatus) {
        this.idOrderStatus = idOrderStatus;
        this.orderStatus = orderStatus;
    }

    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

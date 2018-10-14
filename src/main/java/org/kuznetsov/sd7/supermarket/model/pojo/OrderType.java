package org.kuznetsov.sd7.supermarket.model.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderType {

    private int idOrderType;

    @Size(min = 1)
    private String orderType;

    @NotNull
    @Min(0)
    private Double cost;

    public OrderType() {
    }

    public OrderType(int idOrderType, String orderType, Double cost) {
        this.idOrderType = idOrderType;
        this.orderType = orderType;
        this.cost = cost;
    }

    public OrderType(String orderType, Double cost) {
        this.orderType = orderType;
        this.cost = cost;
    }

    public void setIdOrderType(int idOrderType) {
        this.idOrderType = idOrderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getIdOrderType() {
        return idOrderType;
    }

    public String getOrderType() {
        return orderType;
    }

    public Double getCost() {
        return cost;
    }
}

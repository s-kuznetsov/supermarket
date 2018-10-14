package org.kuznetsov.sd7.supermarket.model.pojo;

import java.util.Date;

public class Order {
    private long idOrder;
    private long idClient;
    private Client client;
    private Date dateOfCreation;
    private Date dateOfCompletion;
    private double cost;
    private String orderStatus;
    private String orderType;

    public Order() {
    }

    public Order(long idOrder, long idClient, Client client,
                 Date dateOfCreation, Date dateOfCompletion, double cost, String orderStatus, String orderType) {
        this(idClient, dateOfCreation, cost, orderStatus, orderType);
        this.idOrder = idOrder;
        this.client = client;
        this.dateOfCompletion = dateOfCompletion;
    }

    public Order(long idClient, Date dateOfCreation, double cost, String orderStatus, String orderType) {
        this.idClient = idClient;
        this.dateOfCreation = dateOfCreation;
        this.cost = cost;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(Date dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idClient=" + idClient +
                ", client=" + client +
                ", dateOfCreation=" + dateOfCreation +
                ", dateOfCompletion=" + dateOfCompletion +
                ", cost=" + cost +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}

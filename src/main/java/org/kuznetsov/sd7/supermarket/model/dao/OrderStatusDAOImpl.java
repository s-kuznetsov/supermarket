package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStatusDAOImpl implements OrderStatusDAO {
    private static final String ALL_ORDER_STATUSES = "SELECT * FROM ORDER_STATUSES";
    private static final String GET_ID_BY_VALUE = "SELECT * FROM ORDER_STATUSES WHERE order_status = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<OrderStatus> rowMapper = (rs, rowNum) -> {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setIdOrderStatus(rs.getInt("id_order_status"));
        orderStatus.setOrderStatus(rs.getString("order_status"));
        return orderStatus;
    };

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return jdbcTemplate.query(ALL_ORDER_STATUSES, rowMapper);
    }

    @Override
    public int getIdOrderStatusByValue(String orderStatus) {
        List<OrderStatus> orderStatuses = jdbcTemplate.query(GET_ID_BY_VALUE, rowMapper, orderStatus);
        OrderStatus orderStatusFound = DataAccessUtils.singleResult(orderStatuses);
        return orderStatusFound.getIdOrderStatus();
    }
}

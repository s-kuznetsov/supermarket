package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("Duplicates")
public class OrderTypeDAOImpl implements OrderTypeDAO {
    private static final String ALL_ORDER_TYPES = "SELECT * FROM TYPES_OF_ORDERS";
    private static final String GET_ID_BY_VALUE = "SELECT * FROM TYPES_OF_ORDERS WHERE order_type = ?";
    private static final String DELETE_ORDER_TYPE = "DELETE FROM TYPES_OF_ORDERS WHERE id_order_type=?";
    private static final String GET_ORDER_TYPE_BY_ID = "SELECT * FROM TYPES_OF_ORDERS WHERE id_order_type=?";
    private static final String GET_ORDER_TYPE_BY_NAME = "SELECT * FROM TYPES_OF_ORDERS WHERE order_type=?";
    private static final String UPDATE_ORDER_TYPE = "UPDATE TYPES_OF_ORDERS SET  order_type = ?, cost = ? WHERE id_order_type = ?";
    private static final String INSERT_ORDER_TYPE = "INSERT INTO TYPES_OF_ORDERS (order_type, cost) VALUES (?, ?)";

    private static final Logger log = Logger.getLogger(OrderTypeDAOImpl.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<OrderType> rowMapper = (rs, rowNum) -> {
        OrderType orderType = new OrderType();
        orderType.setIdOrderType(rs.getInt("id_order_type"));
        orderType.setOrderType(rs.getString("order_type"));
        orderType.setCost(rs.getDouble("cost"));
        return orderType;
    };

    private PreparedStatementSetter getPreparedStatementSetterInsert(final OrderType orderType) {
        return ps -> {
            int i = 0;
            ps.setString(++i, orderType.getOrderType());
            ps.setDouble(++i, orderType.getCost());
        };
    }

    @Override
    public List<OrderType> getAllOrderTypes() {
        return jdbcTemplate.query(ALL_ORDER_TYPES, rowMapper);
    }

    @Override
    public int getIdOrderTypeByValue(String orderType) {
        List<OrderType> orderTypes = jdbcTemplate.query(GET_ID_BY_VALUE, rowMapper, orderType);
        OrderType orderTypeFound = DataAccessUtils.singleResult(orderTypes);
        return orderTypeFound.getIdOrderType();
    }

    @Override
    public void deleteOrderTypeById(long idOrderType) {
        jdbcTemplate.update(DELETE_ORDER_TYPE, idOrderType);
    }

    @Override
    public OrderType getOrderTypeById(long idOrderType) {
        List<OrderType> orderTypes = jdbcTemplate.query(GET_ORDER_TYPE_BY_ID, rowMapper, idOrderType);
        return DataAccessUtils.singleResult(orderTypes);
    }

    @Override
    public void editOrderType(OrderType orderType) {
        jdbcTemplate.update(UPDATE_ORDER_TYPE, ps -> {
            int i = 0;
            ps.setString(++i, orderType.getOrderType());
            ps.setDouble(++i, orderType.getCost());
            ps.setInt(++i, orderType.getIdOrderType());
        });
    }

    @Override
    public void insertOrderType(OrderType orderType) {
        jdbcTemplate.update(INSERT_ORDER_TYPE, ps -> {
            int i = 0;
            ps.setString(++i, orderType.getOrderType());
            ps.setDouble(++i, orderType.getCost());
        });
    }

    @Override
    public OrderType findProductByName(String orderType) {

        List<OrderType> orderTypes = jdbcTemplate.query(GET_ORDER_TYPE_BY_NAME, rowMapper, orderType);
        return DataAccessUtils.singleResult(orderTypes);
    }
}

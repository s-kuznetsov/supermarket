package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private ClientDAO clientDAO;
    private OrderTypeDAO orderTypeDAO;
    private OrderStatusDAO orderStatusDAO;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Autowired
    public void setOrderTypeDAO(OrderTypeDAO orderTypeDAO) {
        this.orderTypeDAO = orderTypeDAO;
    }

    @Autowired
    public void setOrderStatusDAO(OrderStatusDAO orderStatusDAO) {
        this.orderStatusDAO = orderStatusDAO;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String ALL_ORDERS = "Select id_order, id_client, date_of_order_creation," +
            " date_of_completion_of_work, cost, order_status, order_type from orders " +
            "left join order_statuses on orders.id_order_status = order_statuses.id_order_status " +
            "left join types_of_orders on orders.id_order_type = types_of_orders.id_order_type;";
    private static final String GET_ORDERS_OF_THIS_CLIENT = "Select id_order, id_client, date_of_order_creation," +
            " date_of_completion_of_work, cost, order_status, order_type from orders " +
            "left join order_statuses on orders.id_order_status = order_statuses.id_order_status " +
            "left join types_of_orders on orders.id_order_type = types_of_orders.id_order_type WHERE id_client = ?";
    private static final String DELETE_ORDER = "DELETE FROM ORDERS WHERE id_order=?";
    private static final String INSERT_ORDER = "INSERT INTO ORDERS (id_client, date_of_order_creation," +
            " date_of_completion_of_work, id_order_status, id_order_type) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_ORDER = "UPDATE ORDERS SET  date_of_completion_of_work = ?," +
            " id_order_status = ? WHERE id_order = ?";

    private RowMapper<Order> rowMapper = new RowMapper<Order>() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();

            long idClient = rs.getInt("id_client");
            Client client = clientDAO.getClientById(idClient);

            order.setIdOrder(rs.getInt("id_order"));
            order.setIdClient(idClient);
            order.setClient(client);
            order.setDateOfCreation(rs.getDate("date_of_order_creation"));
            order.setDateOfCompletion(rs.getDate("date_of_completion_of_work"));
            order.setCost(rs.getDouble("cost"));
            order.setOrderStatus(rs.getString("order_status"));
            order.setOrderType(rs.getString("order_type"));
            return order;
        }
    };

    @Override
    public List<Order> getAllOrders() {
        return jdbcTemplate.query(ALL_ORDERS, rowMapper);
    }

    @Override
    public List<Order> getAllOrdersOfThisClient(Client client) {
        return jdbcTemplate.query(GET_ORDERS_OF_THIS_CLIENT, rowMapper, client.getidClient());
    }

    @Override
    public void insertOrder(Order order) {
        jdbcTemplate.update(INSERT_ORDER, ps -> {
            int i = 0;
            ps.setLong(++i, order.getIdClient());
            ps.setDate(++i, new Date(order.getDateOfCreation().getTime()));
            ps.setDate(++i, (order.getDateOfCompletion() != null) ? new Date(order.getDateOfCompletion().getTime()) : null);
            int idOrderStatus = orderStatusDAO.getIdOrderStatusByValue(order.getOrderStatus());
            ps.setInt(++i, idOrderStatus);
            int idOrderType = orderTypeDAO.getIdOrderTypeByValue(order.getOrderType());
            ps.setInt(++i, idOrderType);
        });
    }

    @Override
    public void deleteOrder(Order order) {
        jdbcTemplate.update(DELETE_ORDER, order.getIdOrder());

    }

    @Override
    public void deleteOrderById(long idOrder) {
        jdbcTemplate.update(DELETE_ORDER, idOrder);
    }

    @Override
    public void updateOrder(Order order) {
        jdbcTemplate.update(UPDATE_ORDER, ps -> {
            int i = 0;
            ps.setDate(++i, new Date(order.getDateOfCompletion().getTime()));
            int idOrderStatus = orderStatusDAO.getIdOrderStatusByValue(order.getOrderStatus());
            ps.setInt(++i, idOrderStatus);
            ps.setLong(++i, order.getIdOrder());
        });
    }
}

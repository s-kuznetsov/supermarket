package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("Duplicates")
public class ClientDAOImpl implements ClientDAO {

    private static final String ALL_CLIENTS = "SELECT * FROM CLIENTS";
    private static final String INSERT_CLIENT = "INSERT INTO CLIENTS (NAME, SURNAME, PATRONYMIC, PHONE, LOGIN, PASSWORD, role, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CLIENT = "DELETE FROM CLIENTS WHERE id_client=?";
    private static final String UPDATE_CLIENT = "UPDATE CLIENTS SET NAME = ?, SURNAME = ?, PATRONYMIC = ?, PHONE = ?, login = ?, password = ?, role = ?, email = ? WHERE id_client = ?";
    private static final String GET_CLIENT_BY_ID = "SELECT * FROM CLIENTS WHERE id_client=?";
    private static final String GET_CLIENT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM CLIENTS WHERE login=? AND password=?";
    private static final String GET_CLIENT_BY_LOGIN = "SELECT * FROM CLIENTS WHERE login=?";
    private static final String GET_CLIENT_BY_PHONE = "SELECT * FROM CLIENTS WHERE phone=?";
    private static final String GET_CLIENT_BY_EMAIL = "SELECT * FROM CLIENTS WHERE email=?";

    private JdbcTemplate jdbcTemplate;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    private RowMapper<Client> rowMapper = (rs, rowNum) -> {
        Client client = new Client();
        client.setidClient(rs.getInt("id_client"));
        client.setName(rs.getString("name"));
        client.setSurname(rs.getString("surname"));
        client.setPatronymic(rs.getString("patronymic"));
        client.setPhone(rs.getString("phone"));
        client.setLogin(rs.getString("login"));
        client.setPassword(rs.getString("password"));
        client.setRole(rs.getString("role"));
        client.setEmail(rs.getString("email"));
        return client;
    };

    @Override
    public List<Client> getAllClients() {
        return jdbcTemplate.query(ALL_CLIENTS, rowMapper);
    }

    @Override
    public void insertClient(Client client) {
        jdbcTemplate.update(INSERT_CLIENT, ps -> {
            int i = 0;
            ps.setString(++i, client.getName());
            ps.setString(++i, client.getSurname());
            ps.setString(++i, client.getPatronymic());
            ps.setString(++i, client.getPhone());
            ps.setString(++i, client.getLogin());
            ps.setString(++i, encoder.encode(client.getPassword()));
            ps.setString(++i, client.getRole());
            ps.setString(++i, client.getEmail());
        });
    }

    @Override
    public void deleteClient(Client client) {
        jdbcTemplate.update(DELETE_CLIENT, client.getidClient());
    }

    @Override
    public void updateClient(Client client) {
        jdbcTemplate.update(UPDATE_CLIENT, ps -> {
            int i = 0;
            ps.setString(++i, client.getName());
            ps.setString(++i, client.getSurname());
            ps.setString(++i, client.getPatronymic());
            ps.setString(++i, client.getPhone());
            ps.setString(++i, client.getLogin());
            ps.setString(++i, encoder.encode(client.getPassword()));
            ps.setString(++i, client.getRole());
            ps.setString(++i, client.getEmail());
            ps.setLong(++i, client.getidClient());
        });
    }

    @Override
    public Client getClientById(long id) {
        List<Client> clients = jdbcTemplate.query(GET_CLIENT_BY_ID, rowMapper, id);
        return DataAccessUtils.singleResult(clients);
    }

    @Override
    public Client findClientByLoginAndPassword(String login, String password) {
        List<Client> clients = jdbcTemplate.query(GET_CLIENT_BY_LOGIN_AND_PASSWORD, rowMapper, login, password);
        return DataAccessUtils.singleResult(clients);
    }

    @Override
    public Client findClientByLogin(String login) {
        List<Client> clients = jdbcTemplate.query(GET_CLIENT_BY_LOGIN, rowMapper, login);
        return DataAccessUtils.singleResult(clients);
    }

    @Override
    public Client findByNumberPhone(String phone) {
        List<Client> clients = jdbcTemplate.query(GET_CLIENT_BY_PHONE, rowMapper, phone);
        return DataAccessUtils.singleResult(clients);
    }

    @Override
    public Client findByEmail(String email) {
        List<Client> clients = jdbcTemplate.query(GET_CLIENT_BY_EMAIL, rowMapper, email);
        return DataAccessUtils.singleResult(clients);
    }
}

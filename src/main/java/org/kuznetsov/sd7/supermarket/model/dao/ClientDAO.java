package org.kuznetsov.sd7.supermarket.model.dao;

import org.kuznetsov.sd7.supermarket.model.exceptions.CustomException;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> getAllClients();
    void insertClient(Client client) throws CustomException;
    void deleteClient(Client client) throws CustomException;
    void updateClient(Client client);
    Client getClientById(long id);
    Client findClientByLoginAndPassword(String login, String password);
    Client findClientByLogin(String login);
    Client findByNumberPhone(String phone);
    Client findByEmail(String email);
}

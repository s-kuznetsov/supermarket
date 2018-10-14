package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.exceptions.CustomException;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;

import java.util.List;

public interface ClientService {
    Client findByLogin(String login);
    Client findClient(Client client);
    void addClient(Client client) throws CustomException;
    List<Client> getAllClients();
    Client getClientById(long id);
    Client findByNumberPhone(String phone);
    Client findByEmail(String email);
}

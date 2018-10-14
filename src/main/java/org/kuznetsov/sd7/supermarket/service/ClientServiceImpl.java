package org.kuznetsov.sd7.supermarket.service;

import org.kuznetsov.sd7.supermarket.model.dao.ClientDAO;
import org.kuznetsov.sd7.supermarket.model.dao.ClientDAOImpl;
import org.kuznetsov.sd7.supermarket.model.exceptions.CustomException;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client findByLogin(String login) {
        return clientDAO.findClientByLogin(login);
    }

    @Override
    public Client findClient(Client client) {
        return clientDAO.findClientByLoginAndPassword(client.getLogin(), client.getPassword());
    }

    @Override
    public void addClient(Client client) throws CustomException {
        clientDAO.insertClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    public Client getClientById(long id) {
        return clientDAO.getClientById(id);
    }

    @Override
    public Client findByNumberPhone(String phone) {
        return clientDAO.findByNumberPhone(phone);
    }

    @Override
    public Client findByEmail(String email) {
        return clientDAO.findByEmail(email);
    }
}

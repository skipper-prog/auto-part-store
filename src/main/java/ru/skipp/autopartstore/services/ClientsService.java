package ru.skipp.autopartstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skipp.autopartstore.model.Car;
import ru.skipp.autopartstore.model.Client;
import ru.skipp.autopartstore.repository.CarRepository;
import ru.skipp.autopartstore.repository.ClientsRepository;

import java.util.List;
import java.util.Map;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public void saveClient(String clientName, Client client, Map<String, String> form) {
        clientsRepository.save(client);
    }

    public List<Client> findAll(){
        return clientsRepository.findAll();
    }

    public void saveClient(Client client, Client clientNew) {
        client.clone(clientNew);
        clientsRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        clientsRepository.deleteById(clientId);
    }

    public void deleteClient(Client client) {
        clientsRepository.delete(client);
    }
}

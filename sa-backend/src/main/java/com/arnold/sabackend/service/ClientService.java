package com.arnold.sabackend.service;

import com.arnold.sabackend.repositories.ClientRepository;
import com.arnold.sabackend.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        Client existingClient = clientRepository.findByEmail(client.getEmail());

        //Add to be only if it's not present.
        if(existingClient == null){
            clientRepository.save(client);
        }
    }

    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }

    public Client findClientById(int id) {
        final Optional<Client> optionalClient = clientRepository.findById(id);

        //If the client with the given id doesn't exist, return null
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client client) {
        Client dbClient = clientRepository.findByEmail(client.getEmail());

        if(dbClient == null){
            dbClient= clientRepository.save(client);
        }

        return dbClient;
    }
}

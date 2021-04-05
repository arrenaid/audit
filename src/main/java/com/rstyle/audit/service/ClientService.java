package com.rstyle.audit.service;

import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void createClient(ClientEntity client) {
        clientRepository.save(client);
    }
    public List<ClientEntity> findAllClient(){
        return clientRepository.findAll();
    }
}

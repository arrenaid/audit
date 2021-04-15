package com.rstyle.audit.service;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientArrestListEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ClientArrestListRepository;
import com.rstyle.audit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArrestService arrestService;
    @Autowired
    private ClientArrestListRepository repositoryList;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public void createClient(ClientEntity client) {
        updateArrestList(client);
        clientRepository.save(client);
    }
    public List<ClientEntity> findAllClient(){
        return clientRepository.findAll();
    }
    public void updateArrestList(ClientEntity client){
        try {
            List<ClientArrestListEntity> list = repositoryList.findByIdClient(client.getClient_id());
            client.setArrestList(list.size());
        }catch (Exception e){
            e.printStackTrace();
            client.setArrestList(0);
        }
        clientRepository.save(client);
    }
    public boolean existById(int id) {
        return clientRepository.existsById(id);
    }
    public ClientEntity findById(int id) {
        Optional<ClientEntity> client = clientRepository.findById(id);
        return client.get();
    }
    public void Delete(ClientEntity client) {
        List<ArrestEntity> arrests = arrestService.findAllArrestByClientId(client.getClient_id());
        arrests.forEach(cnt -> {
            arrestService.delete(cnt);
        });
        clientRepository.delete(client);
    }
    public List<ClientEntity> search(String key) {
        List<ClientEntity> result = clientRepository.findByFirstNameContainingIgnoreCase(key);
        result.addAll(clientRepository.findByLastNameContainingIgnoreCase(key));
        //result.addAll(clientRepository.findByTypeDocContainingIgnoreCase(Integer.parseInt(key)));//typeDoc;
        result.addAll(clientRepository.findByNumberDocContainingIgnoreCase(key));//numberDoc;
        result.addAll(clientRepository.findBySeriesDocContainingIgnoreCase(key));//seriesDoc;
        return result;
    }
}

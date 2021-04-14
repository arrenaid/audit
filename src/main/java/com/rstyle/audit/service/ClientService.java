package com.rstyle.audit.service;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientArrestListEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ArrestRepository;
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
        //updateLocalArrestList(client);
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

//    public Optional<ClientEntity> findById(int id) {
//        return clientRepository.findById(id);
//    }
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

//    private void updateLocalArrestList(ClientEntity client){
//        List<ClientArrestListEntity> list = repositoryList.findByIdClientAll(client.getClient_id());
//        list.forEach(listCnt ->{
//            Optional<ArrestEntity> arrest = arrestRepository.findById(listCnt.getIdArrest());
//            client.addLocalArrestList(arrest.get());
//        });
//    }
}

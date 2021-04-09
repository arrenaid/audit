package com.rstyle.audit.service;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientArrestListEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ArrestRepository;
import com.rstyle.audit.repository.ClientArrestListRepository;
import com.rstyle.audit.repository.ClientRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArrestRepository arrestRepository;
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
    private void updateArrestList(ClientEntity client){
        client.setArrestList(0);
        List<ClientArrestListEntity> list = repositoryList.findByIdClientAll(client.getClient_id());
        list.forEach(listCnt ->{
            client.setArrestList(client.getArrestList()+1);
        });
    }
//    private void updateLocalArrestList(ClientEntity client){
//        List<ClientArrestListEntity> list = repositoryList.findByIdClientAll(client.getClient_id());
//        list.forEach(listCnt ->{
//            Optional<ArrestEntity> arrest = arrestRepository.findById(listCnt.getIdArrest());
//            client.addLocalArrestList(arrest.get());
//        });
//    }
}

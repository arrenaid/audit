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
public class ArrestService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArrestRepository arrestRepository;
    @Autowired
    private ClientArrestListRepository repositoryList;

    public ArrestService (ArrestRepository arrestRepository){
        this.arrestRepository = arrestRepository;
    }

    public void createArrest(ArrestEntity arrest,int clientId) {
        arrestRepository.save(arrest);
        createClientArrestList(clientId,arrest.getArrest_id());
    }
    public List<ArrestEntity> findAllArrest(){
        return arrestRepository.findAll();
    }
    private void createClientArrestList(int clientId,int arrestId){
        ClientArrestListEntity object = new ClientArrestListEntity(clientId,arrestId);

        repositoryList.save(object);
    }
    public List<ArrestEntity> findAllArrestByClientId(int clientId){
        List<ArrestEntity> result = null;
        List<ClientArrestListEntity> list = repositoryList.findByIdClientAll(clientId);
        list.forEach(cnt ->{
            Optional<ArrestEntity> arrest = arrestRepository.findById(cnt.getIdArrest());
            result.add(arrest.get());
        });
        return result;
    }
}

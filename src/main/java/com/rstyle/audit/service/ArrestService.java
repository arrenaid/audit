package com.rstyle.audit.service;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientArrestListEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ArrestRepository;
import com.rstyle.audit.repository.ClientArrestListRepository;
import com.rstyle.audit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArrestService {
//    @Autowired
//    private ClientRepository clientRepository;
    @Autowired
    private ArrestRepository arrestRepository;
    @Autowired
    private ClientArrestListRepository repositoryList;
    @Autowired
    private ClientService clientService;

    public ArrestService (ArrestRepository arrestRepository){
        this.arrestRepository = arrestRepository;
    }

    public void createArrest(ArrestEntity arrest,int clientId) {
        arrestRepository.save(arrest);
        createClientArrestList(clientId,arrest.getArrest_id());
    }
    public void updateArrest(int id, int organCode, LocalDate docDate, String docNum,
                             String purpose, Long amount, String refDocNum, int operation) {
        ArrestEntity arrest = findById(id);
        arrest.setOrganCode(organCode);
        arrest.setDocDate(docDate);
        arrest.setDocNum(docNum);
        arrest.setPurpose(purpose);
        arrest.setAmount(amount);
        arrest.setRefDocNum(refDocNum);
        arrest.setOperation(operation);
        arrestRepository.save(arrest);
    }
    public List<ArrestEntity> findAllArrest(){
        return arrestRepository.findAll();
    }
    private void createClientArrestList(int clientId,int arrestId){
        ClientArrestListEntity object = new ClientArrestListEntity(clientId,arrestId);
        repositoryList.save(object);
    }
    public List<ArrestEntity> findAllArrestByClientId(int clientId){
        List<ArrestEntity> result = new ArrayList<>();
        try {
            List<ClientArrestListEntity> list = repositoryList.findByIdClient(clientId);
            list.forEach(cnt -> {
                Optional<ArrestEntity> arrest = arrestRepository.findById(cnt.getIdArrest());
                result.add(arrest.get());
            });
        }
        catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return result;
    }
    public ClientEntity findClientByClientId(int clientId){
        return clientService.findById(clientId);
    }
    public ClientEntity findClientByArrestId(int arrestId){
        return findClientByClientId(repositoryList.findByIdArrest(arrestId).getIdClient());
    }

    public ArrestEntity findById(int id) {
        Optional<ArrestEntity> result = arrestRepository.findById(id);
        return result.get();
    }

    public void delete(ArrestEntity arrest) {
        ClientArrestListEntity list = repositoryList.findByIdArrest(arrest.getArrest_id());
        repositoryList.delete(list);
        arrestRepository.delete(arrest);
    }

    public boolean existById(int id) {
        return arrestRepository.existsById(id);
    }
//    public void updateClientWithArrestList(int id) {
//        try {
//            ClientEntity client = findClientArrestById(id);
////            Optional<ClientEntity> client = clientService.findById(id);
////            ArrayList<ClientEntity> list = new ArrayList<>();
////            client.ifPresent(list::add);
////            clientService.updateArrestList(list.get(0));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}

package com.rstyle.audit.controller;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ArrestRepository;
import com.rstyle.audit.service.ArrestService;
import com.rstyle.audit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ArrestController {
    @Autowired
    private ArrestService service;
    @Autowired
    private ClientService clientService;

    @GetMapping("/arrest")
    public String arrestMain(Model model) {
        Iterable<ArrestEntity> arrests = service.findAllArrest();
        model.addAttribute("arrests", arrests);
        model.addAttribute("title", "Аресты клиентов");
        return "arrest";
    }
    @GetMapping("/arrest/{id}")
    public String arrestView(@PathVariable(value = "id") int clientId, Model model) {
        Iterable<ArrestEntity> arrestsThisClient = service.findAllArrestByClientId(clientId);
        ClientEntity client = service.findClientByClientId(clientId);
        model.addAttribute("arrests", arrestsThisClient);
        model.addAttribute("title", "Арест клиента: " + client.getLastName() + " " + client.getFirstName());
        model.addAttribute("id", clientId);
        return "arrest";
    }

//    @GetMapping("/arrest/add")
//    public String arrestAdd(Model model) {
//        model.addAttribute("title", "Добавить арест");
//        return "arrest-add";
//    }
//
//    @PostMapping("/arrest/add")
//    public String arrestAdd(@RequestParam int organ_code, @RequestParam String doc_num,
//                            @RequestParam String purpose, @RequestParam Long amount,
//                            @RequestParam String ref_doc_num, Model model) {
//        ArrestEntity arrest = new ArrestEntity(organ_code, LocalDate.now(), doc_num, purpose, amount, ref_doc_num);
//        //repository.save(arrest);
//        //service.createArrest(arrest,);
//        return "redirect:/arrest";
//    }

    @GetMapping("/arrest/add/{id}") //@RequestParam(name="name", required=false, defaultValue="World") String name
    public String arrestClientAdd(@PathVariable(value = "id") int clientId, Model model) {
        Iterable<ArrestEntity> arrestsThisClient = service.findAllArrestByClientId(clientId);
        ClientEntity client = service.findClientByClientId(clientId);
        model.addAttribute("arrests", arrestsThisClient);
        model.addAttribute("title", "Арест клиента: " + client.getLastName() + " " + client.getFirstName());
        model.addAttribute("id", clientId);
        return "arrest-add";
    }

    @PostMapping("/arrest/add/{id}")
    public String arrestClientAdd(@PathVariable(value = "id") int clientId, @RequestParam int organ_code,
              @RequestParam String doc_num, @RequestParam String purpose, @RequestParam Long amount,
              @RequestParam String ref_doc_num, Model model) {
        ArrestEntity arrest = new ArrestEntity(organ_code, LocalDate.now(), doc_num, purpose, amount, ref_doc_num);
        service.createArrest(arrest, clientId);
        ClientEntity client = service.findClientByClientId(clientId);
        clientService.updateArrestList(client);
        //service.updateClientWithArrestList(id);
        return "redirect:/arrest/" + clientId;
    }
    @GetMapping("/arrest/edit/{id}")
    public String arrestEdit(@PathVariable(value = "id") int arrestId, Model model) {
//        ArrestEntity arrest = service.findById(id).orElseThrow();
        if(!service.existById(arrestId)){
            return "redirect:/";
        }
        ClientEntity client = service.findClientByArrestId(arrestId);
//        Optional<ArrestEntity> arrest = service.findById(arrestId);
//        ArrayList<ArrestEntity> list =new ArrayList<>();
//        arrest.ifPresent(list::add);
//                model.addAttribute("arrest", list);
        ArrestEntity arrest = service.findById(arrestId);
        model.addAttribute("arrest", arrest);
        model.addAttribute("title", "Редактировать арест килиента: " + client.getLastName() + " " + client.getFirstName());
        model.addAttribute("id", arrestId);
        return "arrest-edit";
    }

    @PostMapping("/arrest/edit/{id}")
    public String arrestEdit(@PathVariable(value = "id") int arrestId, @RequestParam int organ_code,
                                  @RequestParam String doc_num, @RequestParam String purpose, @RequestParam Long amount,
                                  @RequestParam String ref_doc_num, @RequestParam int operation, Model model) {
        ClientEntity client = service.findClientByArrestId(arrestId);
        service.updateArrest(arrestId, organ_code, LocalDate.now(), doc_num, purpose, amount, ref_doc_num, operation);
        return "redirect:/arrest/" +  client.getClient_id();
    }
    @PostMapping("/arrest/remove/{id}")
    public String arrestDelete(@PathVariable(value = "id") int arrestId,  Model model){
        if(!service.existById(arrestId)){
            return "redirect:/client";
        }
        ArrestEntity arrest = service.findById(arrestId);
        ClientEntity client = service.findClientByArrestId(arrestId);
        service.delete(arrest);
        clientService.updateArrestList(client);
        return "redirect:/arrest/" +  client.getClient_id();
    }
}

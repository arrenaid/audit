package com.rstyle.audit.controller;

import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public String clientsMain(Model model){
        Iterable<ClientEntity> clients = clientService.findAllClient();
        model.addAttribute("clients",clients);
        return "client";
    }
    @GetMapping("/client/add")
    public String clientsAdd(Model model){
        model.addAttribute("title","client add");
        return "client-add";
    }
    @PostMapping("/client/add")
    public String clientsAddPost(@RequestParam String last_name, @RequestParam String first_name,
                                 @RequestParam int ident_doc, @RequestParam("date_of_birth") @DateTimeFormat(pattern="yyyy-MM-dd") Date date_of_birth,
                                 @RequestParam String place_of_birth,@RequestParam int arrest_list,  Model model){
        ClientEntity client = new ClientEntity(last_name,first_name,ident_doc, date_of_birth,place_of_birth,arrest_list);
        clientService.createClient(client);
        return "redirect:/client";
    }
}

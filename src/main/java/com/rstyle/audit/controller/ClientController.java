package com.rstyle.audit.controller;

import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String clientMain(Model model){
        Iterable<ClientEntity> clients = clientService.findAllClient();
        model.addAttribute("clients",clients);
        model.addAttribute("title","Список всех клиентов:");
        return "client";
    }
    @RequestMapping(value = "/search")
    public String clientSearch(@RequestParam(value = "key", required = false) String key,Model model){
        Iterable<ClientEntity> result = clientService.search(key);
        model.addAttribute("clients",result);
        model.addAttribute("title","Результаты поиска клиентов:");
        return "client";
    }

    @GetMapping("/client/add")
    public String clientAdd(Model model){
        model.addAttribute("title","Новый клиент");
        return "client-add";
    }
    @PostMapping("/client/add")
    public String clientAdd(@RequestParam String last_name, @RequestParam String first_name,
                            @RequestParam("date_of_birth") @DateTimeFormat(pattern="yyyy-MM-dd") Date date_of_birth,
                            @RequestParam String place_of_birth,@RequestParam int type_doc,
                            @RequestParam String number_doc, @RequestParam String series_doc,  Model model){
        ClientEntity client = new ClientEntity(last_name,first_name, date_of_birth,place_of_birth,type_doc,number_doc,
                series_doc);
        clientService.createClient(client);
        return "redirect:/";
    }

    @GetMapping("/client/{id}/edit")
    public String clientEdit(@PathVariable(value = "id") int clientId, Model model){
        ClientEntity client = clientService.findById(clientId);
        model.addAttribute("client",client);
        model.addAttribute("id",clientId);
        model.addAttribute("title","Редактировать данные клиента");
        return "client-edit";
    }
    @PostMapping("/client/{id}/edit")
    public String clientEdit(@PathVariable(value = "id") int id, @RequestParam String last_name,
                             @RequestParam String first_name,
                             @RequestParam("date_of_birth") @DateTimeFormat(pattern="yyyy-MM-dd") Date date_of_birth,
                             @RequestParam String place_of_birth,@RequestParam int type_doc,@RequestParam String number_doc,
                             @RequestParam String series_doc,
                             @RequestParam("issue_date_doc") @DateTimeFormat(pattern="yyyy-MM-dd") Date issue_date_doc,
                             Model model){
        ClientEntity client = clientService.findById(id);
        client.Update(last_name,first_name, date_of_birth,place_of_birth,
                type_doc,number_doc,series_doc,issue_date_doc);
        clientService.updateArrestList(client);
        clientService.createClient(client);
        return "redirect:/";
    }
    @PostMapping("/client/{id}/remove")
    public String clientDelete(@PathVariable(value = "id") int id,  Model model){
        ClientEntity client = clientService.findById(id);
        clientService.Delete(client);
        return "redirect:/";
    }

}

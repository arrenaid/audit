package com.rstyle.audit.controller;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.entity.ClientEntity;
import com.rstyle.audit.repository.ArrestRepository;
import com.rstyle.audit.service.ArrestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class ArrestController {
    @Autowired
    private ArrestService service;
    @GetMapping("/arrest")
    public String arrestMain( Model model) {
        Iterable<ArrestEntity> arrests = service.findAllArrest();
        model.addAttribute("arrests", arrests);
        return "arrest";
    }
    @GetMapping("/arrest/add")
    public String arrestAdd( Model model) {
        model.addAttribute("title", "Добавить арест");
        return "arrest-add";
    }
    @PostMapping("/arrest/add")
    public String arrestAdd(@RequestParam int organ_code, @RequestParam String doc_num,
                            @RequestParam String purpose,@RequestParam  Long amount,
                            @RequestParam String ref_doc_num, Model model){
        ArrestEntity arrest = new ArrestEntity(organ_code, LocalDate.now(),doc_num,purpose, amount,ref_doc_num);
        //repository.save(arrest);
        //service.createArrest(arrest,);
        return "redirect:/arrest";
    }

    @GetMapping("/arrestClient")
    public String arrestClient(@RequestParam("el") ClientEntity client, Model model) {
        Iterable<ArrestEntity> arrestsThisClient = service.findAllArrestByClientId(client.getClient_id());
        model.addAttribute("arrests", arrestsThisClient);
        model.addAttribute("client", client);
        return "arrest";
    }
}
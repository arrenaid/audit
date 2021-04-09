package com.rstyle.audit.controller;

import com.rstyle.audit.entity.ArrestEntity;
import com.rstyle.audit.repository.ArrestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "main");
        return "home";
    }
    @GetMapping("/doc")
    public String doc( Model model) {
        model.addAttribute("title", "Doc");
        return "doc";
    }
    @GetMapping("*")
    public String notFound( Model model) {
        model.addAttribute("title", "not found");
        return "not-found";
    }
}

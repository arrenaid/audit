package com.rstyle.audit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "main");
        return "home";
    }
    @GetMapping("/client")
    public String client( Model model) {
        model.addAttribute("title", "Client");
        return "client";
    }
    @GetMapping("/arrest")
    public String arrest( Model model) {
        model.addAttribute("title", "Arrest");
        return "arrest";
    }
    @GetMapping("/doc")
    public String doc( Model model) {
        model.addAttribute("title", "Doc");
        return "doc";
    }

}

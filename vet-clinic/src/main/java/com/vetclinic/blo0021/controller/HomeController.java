package com.vetclinic.blo0021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "index";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager_page";
    }
}

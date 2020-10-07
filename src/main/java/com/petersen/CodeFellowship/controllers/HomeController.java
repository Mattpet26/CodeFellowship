package com.petersen.CodeFellowship.controllers;

import com.petersen.CodeFellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String showHome(Model m, Principal principal){
        m.addAttribute("principal", principal);
        return "home";
    }

}

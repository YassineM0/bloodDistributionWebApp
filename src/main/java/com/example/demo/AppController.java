package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

@Controller
public class AppController {
    @Autowired
    private UserRepo repo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);

        System.out.println("User registered: " + user.getEmail());

        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList() {
        return "users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

   

    @GetMapping("/users")
    public String getUser() {
        return "users";
    }

    @GetMapping("/Admin")
    public String getAdmin() {
        return "admin malik";
    }

}

package com.myexpensetracker.ExpenseTracker.controller;
import com.myexpensetracker.ExpenseTracker.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController {

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name ="loginForm")LoginForm loginForm, Model model){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        if("admin".equals(username) && "admin".equals(password)){
            return "redirect:/expense";
        }
        model.addAttribute("errorMessage", "FAILED TO LOGIN");
        return "login";
    }
}





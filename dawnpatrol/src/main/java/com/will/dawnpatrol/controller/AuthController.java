package com.will.dawnpatrol.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    HttpServletRequest httpServletRequest;


    //Attempts at clearing the context
    @GetMapping("/logout")
    public String logoutUserRoute(Model model) throws ServletException {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        httpServletRequest.logout();
        model.addAttribute("logout", "Logged out Successfully");
        return "login.html";
    }

    @GetMapping("/login")
    public String loginForm(Model model, String error, String logout){
        if(error !=null){
            model.addAttribute("error", "Your username and password are invalid");
        }

        if(logout != null){
            model.addAttribute("logout", "You have been logged out successfully");
        }

        return "login.html";
    }

}

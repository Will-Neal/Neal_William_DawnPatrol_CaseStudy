package com.will.dawnpatrol.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author willw
 * Handles the routes for login  and logout. Injects an HTTPServletRequest with field injection.
 * logoutUserRoute destroys the user session and returns them to the login page when the route is hit.
 * loginForm takes in Model model, and Strings error and logout and either takes the user straight to the login page or passes 
 * error or logout through to the user. 
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    HttpServletRequest httpServletRequest;


    //Exception Handling
    /**
     * @param model
     * @return
     * @throws ServletException
     * Sets the authentication to null, clears the session and logs the usre out of the http servlet.
     * returns the template login.html
     */
    @GetMapping("/logout")
    public String logoutUserRoute(Model model) throws ServletException {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        httpServletRequest.logout();
        model.addAttribute("logout", "Logged out Successfully");
        return "login.html";
    }

    /**
     * @param model
     * @param error
     * @param logout
     * @return
     * Takes in a Model and two Strings, returns the login.html template and passes through the error or logout status if applicable.
     * 
     */
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

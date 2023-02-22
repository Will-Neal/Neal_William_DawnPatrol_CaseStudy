package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author willw
 * Handles routes associated with the User object that arent authorization.
 * Two methods - getRegister and postRegister.
 * All routes have sub domain "/user".
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	User user;

	@Autowired
	PasswordEncoder encoder;

	/**
	 * @param model
	 * @return
	 * Adds the user model and returns the register template. 
	 */
	@GetMapping("/register")
	public String getRegister(Model model){
		model.addAttribute("user", user);
		return "register.html";
	}

	//error handling
	/**
	 * @param model
	 * @param user
	 * @return
	 * @throws SQLIntegrityConstraintViolationException
	 * Takes in model for databind and the User model from the register form. 
	 * Checks to confirm that supplied email is unique and if so saves to the database. 
	 * Throws SQLIntegrityConstraintViolationException if the user cannot be saved because it already exists. 
	 */
	@PostMapping("/register")
	public String postRegister(Model model, @ModelAttribute("user") User user) throws SQLIntegrityConstraintViolationException{
			String email = user.getEmail();
		System.out.println("post");
		System.out.println(user);
			if(userService.checkUnique(email)) {
				System.out.println("IF");
				userService.addNewUser(user, encoder);
				return "login.html";
			} else {
				System.out.println("else");
				model.addAttribute("error", "error");
				return "register.html";
			}
	}	
}

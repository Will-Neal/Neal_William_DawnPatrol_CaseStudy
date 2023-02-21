package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	User user;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/register")
	public String getRegister(Model model){
		model.addAttribute("user", user);
		return "register.html";
	}

	//error handling
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



	@GetMapping("/db")
	public String runDb(Model model) {
		List<User> userlist = userService.getAllUsers();
		Optional<User> optionalUser = userService.findUserByEmail("will@email.com");
		User singleUser = optionalUser.get();

		//Get email of signed in User
		Object userContext = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("User context" + userContext);
		System.out.println(userContext.toString());

		model.addAttribute("userList", userlist);
		model.addAttribute("singleUser", singleUser);
		return "db.html";
		
	}
	
}

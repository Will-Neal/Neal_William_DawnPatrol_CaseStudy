package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.SurfboardService;
import com.will.dawnpatrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class SurfboardController {

    @Autowired
    Surfboard surfboard;
    @Autowired
    User user;

    @Autowired
    SurfboardService surfboardService;

    @Autowired
    UserService userService;


    @GetMapping("/quiver")
    public String getSurfboardPage(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Surfboard> userBoards = surfboardService.getSurfboardByUser(activeUser.get());
        System.out.println(userBoards);
        model.addAttribute("surfboard", surfboard);
        model.addAttribute("userBoards", userBoards);
        return "surfboard.html";
    }

    @PostMapping("/quiver")
    public String addSurfboard(Model model, @ModelAttribute("surfboard") Surfboard surfboard){
        Object username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        user.setId(8);
        surfboard.setUser(user);
        surfboardService.addNewSurfboard(surfboard);
        return "test.html";
    }

}
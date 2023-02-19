package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.SpotService;
import com.will.dawnpatrol.service.UserService;
import com.will.dawnpatrol.utils.ContextAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    Spot spot;

    @Autowired
    User user;

    @Autowired
    SpotService spotService;

    @Autowired
    UserService userService;

    @GetMapping("/lineup")
    public String getSpotPage(Model model){
        String username = ContextAccess.getActiveUsername();
        System.out.println(username);
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Spot> userSpots = spotService.getSpotByUser(activeUser.get());

        model.addAttribute("spot", spot);
        model.addAttribute("spots", userSpots);
        return "spot.html";
    }

    @PostMapping("/lineup")
    public String addSpot(Model model, @ModelAttribute("spot") Spot spot){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userByName = userService.findUserByEmail(username);
        User activeUser = userByName.get();

        int userId = activeUser.getId();
        user.setId(userId);
        spot.setUser(user);

        spotService.addNewSpot(spot);
        List<Spot> userSpots = spotService.getSpotByUser(activeUser);

        model.addAttribute("spot", spot);
        model.addAttribute("spots", userSpots);
        return "spot.html";
    }

    @GetMapping("/update/{id}")
    public String getUpdateSpot(@PathVariable("id") int id, Model model){
        Spot spot = spotService.getSpotById(id);
        model.addAttribute("spot", spot);
        return "update_spot.html";
    }

    @PostMapping("/update/{id}")
    public String updateSpot(@PathVariable("id") int id, @ModelAttribute Spot update, Model model){
        Spot current = spotService.getSpotById(id);
        current.setName(update.getName());
        current.setType(update.getType());
        current.setLocation(update.getLocation());
        current.setIdealExposure(update.getIdealExposure());
        current.setIdealWind(update.getIdealWind());
        spotService.addNewSpot(current);

        String username = ContextAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);

        List<Spot> userSpot = spotService.getSpotByUser(activeUser.get());
        model.addAttribute("spots", userSpot);
        return "spot.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteSpot(Model model, @PathVariable("id") int id){
        spotService.deleteSpot(id);
        String username = ContextAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Spot> userSpots = spotService.getSpotByUser(activeUser.get());
        model.addAttribute("spot", spot);
        model.addAttribute("spots", userSpots);
        return "spot.html";
    }

}

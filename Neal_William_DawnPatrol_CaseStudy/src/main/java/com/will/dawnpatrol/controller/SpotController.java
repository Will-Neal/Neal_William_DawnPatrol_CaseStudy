package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.SpotService;
import com.will.dawnpatrol.service.UserService;
import com.will.dawnpatrol.utils.SessionAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author willw
 * Handles routes for Spots. Contains methods getSpotPage, addSpot, getUpdateSpot, updateSpot and deleteSpot.
 * These methods handle CRUD operations according to requests from the front end.  
 * All routes have sub domain "/spot".
 */
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

    /**
     * @param model
     * @return
     * Takes in a Model object for form data-binding. 
     * Uses session to get active user then gets the List of Spots associated with that user. 
     * Returns the spot.html template. 
     */
    @GetMapping("/lineup")
    public String getSpotPage(Model model){
        String username = SessionAccess.getActiveUsername();
        System.out.println(username);
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Spot> userSpots = spotService.getSpotByUser(activeUser.get());

        model.addAttribute("spot", spot);
        model.addAttribute("spots", userSpots);
        return "spot.html";
    }

    /**
     * @param model
     * @param spot
     * @return
     * Takes in a model for data binding and takes in the spot model from the form to add data to database.
     * Saves new spot in database then recalls the database to get newly added data and then returns the spot template.
     */
    @PostMapping("/lineup")
    public String addSpot(Model model, @ModelAttribute("spot") Spot spot){
        String username = SessionAccess.getActiveUsername();
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

    /**
     * @param id
     * @param model
     * @return
     * Takes in a model for data binding  and a path variable. Returns the update_spot template then uses the path variable to populate the 
     * info for the spot to be updated. 
     */
    @GetMapping("/update/{id}")
    public String getUpdateSpot(@PathVariable("id") int id, Model model){
        Spot spot = spotService.getSpotById(id);
        model.addAttribute("spot", spot);
        return "update_spot.html";
    }

    /**
     * @param id
     * @param update
     * @param model
     * @return
     * Takes in a model, pathvariable and model attribute. Takes the form data and updates the correct spot with the new data.
     * Then recalls the database and returns the spot template with the newly update data. 
     */
    @PostMapping("/update/{id}")
    public String updateSpot(@PathVariable("id") int id, @ModelAttribute Spot update, Model model){
        Spot current = spotService.getSpotById(id);
        current.setName(update.getName());
        current.setType(update.getType());
        current.setLocation(update.getLocation());
        current.setIdealExposure(update.getIdealExposure());
        current.setIdealWind(update.getIdealWind());
        spotService.addNewSpot(current);

        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);

        List<Spot> userSpot = spotService.getSpotByUser(activeUser.get());
        model.addAttribute("spots", userSpot);
        return "spot.html";
    }

    /**
     * @param model
     * @param id
     * @return
     * Takes in a Model and path variable. 
     * Uses the id from the path variable to delete the spot then returns the spot template with the new data.
     */
    @PostMapping("/delete/{id}")
    public String deleteSpot(Model model, @PathVariable("id") int id){
        spotService.deleteSpot(id);
        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Spot> userSpots = spotService.getSpotByUser(activeUser.get());
        model.addAttribute("spot", spot);
        model.addAttribute("spots", userSpots);
        return "spot.html";
    }

}

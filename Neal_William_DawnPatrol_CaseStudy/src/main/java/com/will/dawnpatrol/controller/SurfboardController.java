package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.SurfboardService;
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
 * Handles routes for Spots. Contains methods getSurfboardPage, addSurfboard, getUpdateSurfboard, updateSurfboard and deleteSurfboard.
 * These methods handle CRUD operations according to requests from the front end.
 * All routes have sub domain "/board".
 */
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


    /**
     * @param model
     * @return
     * Takes in a Model object for form data-binding. 
     * Uses session to get active user then gets the List of Surfboards associated with that user. 
     * Returns the surfboard.html template. 
     */
    @GetMapping("/quiver")
    public String getSurfboardPage(Model model){
        String username = SessionAccess.getActiveUsername();
        System.out.println(username);
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Surfboard> userBoards = surfboardService.getSurfboardByUser(activeUser.get());

        model.addAttribute("surfboard", surfboard);
        model.addAttribute("surfboards", userBoards);
        return "surfboard.html";
    }

    /**
     * @param model
     * @param surfboard
     * @return
     * Takes in a model for data binding and takes in the surfboard model from the form to add data to database.
     * Saves new surfboard in database then recalls the database to get newly added data and then returns the surfboard template.
     */
    @PostMapping("/quiver")
    public String addSurfboard(Model model, @ModelAttribute("surfboard") Surfboard surfboard){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userByName = userService.findUserByEmail(username);
        User activeUser = userByName.get();

        int userId = activeUser.getId();
        user.setId(userId);
        surfboard.setUser(user);

        surfboardService.addNewSurfboard(surfboard);

        List<Surfboard> userBoards = surfboardService.getSurfboardByUser(activeUser);

        model.addAttribute("surfboard", surfboard);
        model.addAttribute("surfboards", userBoards);
        return "surfboard.html";
    }

    /**
     * @param id
     * @param model
     * @return
     * Takes in a model for data binding and a path variable. Returns the update_surfboard template then uses the path variable to populate the 
     * info for the surfboard to be updated.
     */
    @GetMapping("/update/{id}")
    public String getUpdateSurfboard(@PathVariable("id") int id, Model model){
        Surfboard surfboard = surfboardService.getSurfboardById(id);
        model.addAttribute("surfboard", surfboard);
        return "update_board.html";
    }

    /**
     * @param id
     * @param update
     * @param model
     * @return
     * Takes in a model, pathvariable and model attribute. Takes the form data and updates the correct surfboard with the new data.
     * Then recalls the database and returns the surfboard template with the newly update data.
     */
    @PostMapping("/update/{id}")
    public String updateSurfboard(@PathVariable("id") int id, @ModelAttribute Surfboard update, Model model){
        Surfboard current = surfboardService.getSurfboardById(id);
        System.out.println(current);
        current.setShaper(update.getShaper());
        current.setLength(update.getLength());
        current.setTail(update.getTail());
        current.setFinNum(update.getFinNum());
        current.setFinType(update.getFinType());
        surfboardService.addNewSurfboard(current);

        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);

        List<Surfboard> userBoards = surfboardService.getSurfboardByUser(activeUser.get());
        model.addAttribute("surfboards", userBoards);
        return "surfboard.html";
    }

    /**
     * @param model
     * @param id
     * @return
     * Takes in a Model and path variable. 
     * Uses the id from the path variable to delete the spot then returns the spot template with the new data.
     */
    @PostMapping("/delete/{id}")
    public String deleteSurfboard(Model model, @PathVariable("id") int id){
        surfboardService.deleteSurfboard(id);
        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        List<Surfboard> userBoards = surfboardService.getSurfboardByUser(activeUser.get());
        model.addAttribute("surfboard", surfboard);
        model.addAttribute("surfboards", userBoards);
        return "surfboard.html";
    }

}

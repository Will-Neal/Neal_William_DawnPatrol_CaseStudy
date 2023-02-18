package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.*;
import com.will.dawnpatrol.service.SessionService;
import com.will.dawnpatrol.service.SpotService;
import com.will.dawnpatrol.service.SurfboardService;
import com.will.dawnpatrol.service.UserService;
import com.will.dawnpatrol.utils.ContextAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("DuplicatedCode")
@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SurfboardService surfboardService;

    @Autowired
    UserService userService;

    @Autowired
    SpotService spotService;

    @Autowired
    Session session;

    @Autowired
    SessionService sessionService;


    @GetMapping("/paddle")
    public String getSessionPage(Model model){
        String email = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(email);
        User user = userOptional.get();

        List<Surfboard> surfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> spots = spotService.getSpotByUser(user);
        List<Session> userSessions = sessionService.getSessionByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", surfboards);
        model.addAttribute("spots", spots);


        return "session.html";
    }

    @PostMapping("/paddle")
    public String addSessionPage(Model model, @ModelAttribute("session") Session session){
        System.out.println("session + " + session);
        String email = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(email);
        User user = userOptional.get();
        session.setUser(user);
        sessionService.addNewSession(session);

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        System.out.println(userSessions);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);


        return "session.html";
    }

    @GetMapping("/update/{id}")
    public String getUpdateSession(@PathVariable("id") Long id, Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        Session session = sessionService.getSessionById(id);

        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "updateSession.html";
    }

    @PostMapping("/update/{id}")
    public String updateSession(@PathVariable("id") Long id, @ModelAttribute Session update, Model model){
        Session current = sessionService.getSessionById(id);
        current.setSize(update.getSize());
        current.setPeriod(update.getPeriod());
        current.setDirection(update.getDirection());
        current.setWindStrength(update.getWindStrength());
        current.setWindDirection(update.getWindDirection());
        current.setBoard(update.getBoard());
        current.setBoardRating(update.getBoardRating());
        current.setSpot(update.getSpot());
        current.setRating(update.getRating());
        sessionService.addNewSession(current);

        String username = ContextAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        User user = activeUser.get();

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        return "session.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteSession(Model model, @PathVariable("id") Long id){
        System.out.println(id);
        sessionService.deleteSpot(id);
        String username = ContextAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        User user = activeUser.get();

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        return "session.html";
    }

    @GetMapping("/sortbysizedesc")
    public String sortedBySizeDesc(Model model){
    String username = ContextAccess.getActiveUsername();
    Optional<User> userOptional = userService.findUserByEmail(username);
    User user = userOptional.get();

    List<Session> userSessions = sessionService.getOrderedSessionByUserDesc(user);
    List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
    List<Spot> userSpots = spotService.getSpotByUser(user);

    model.addAttribute("session", session);
    model.addAttribute("sessions", userSessions);
    model.addAttribute("surfboards", userSurfboards);
    model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbysizeasc")
    public String sortedBySizeAsc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.getOrderedSessionByUserAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyratingdesc")
    public String sortedByRatingDesc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByUserByRatingDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyratingasc")
    public String sortedByRatingAsc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByUserByRatingAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyboardasc")
    public String sortedByBoardDesc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByBoardDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyboarddesc")
    public String sortedByBoardAsc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByBoardAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyspotasc")
    public String sortedBySpotDesc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionBySpotDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbyspotdesc")
    public String sortedBySpotAsc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionBySpotAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbydatedesc")
    public String sortedByDateDesc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByDateDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

    @GetMapping("/sortbydateasc")
    public String sortedByDateAsc(Model model){
        String username = ContextAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        List<Session> userSessions = sessionService.orderSessionByDateAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "session.html";
    }

}

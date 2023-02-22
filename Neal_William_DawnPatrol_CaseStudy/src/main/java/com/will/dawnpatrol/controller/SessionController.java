package com.will.dawnpatrol.controller;

import com.will.dawnpatrol.model.*;
import com.will.dawnpatrol.service.SessionService;
import com.will.dawnpatrol.service.SpotService;
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
 * Handles all route mapping for the sessions page. 
 * Contains the methods getSessionPage,addSessionPage, getUpdateSession, updateSession, delete session, sortedBySizeDesc, sortedBySizeAsc, sortedByRatingDesc, sortedByRatingAsc, sortedByBoardDesc, sortedByBoardAsc, sortedBySpotAsc, sortedBySpotDesc, sortedByDateAsc, sortedByDateDesc, and generateWaveData.
 * These methods handle CRUD operations in response to the front-end. 
 * All routes have subdomain "/session".
 */
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


    /**
     * @param model
     * @return
     * Takes in a model for form data binding. 
     * Uses the session to get the active user and then uses the active user to load, Spots, Surfboards and Sessions.
     * Also calls the generateWaveData function. Passes all through to the session.html that is returned.
     */
    @GetMapping("/paddle")
    public String getSessionPage(Model model){
        String email = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(email);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);



        List<Surfboard> surfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> spots = spotService.getSpotByUser(user);
        List<Session> userSessions = sessionService.getSessionByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", surfboards);
        model.addAttribute("spots", spots);
        model.addAttribute("wavedata", waveData);


        return "session.html";
    }

    /**
     * @param model
     * @param session
     * @return
     * Takes in the Model, Session model from the form and save the database adding a new session. Then calls for all Session, Spot, and Surfboard data to re-render the
     * session page which is returned.
     */
    @PostMapping("/paddle")
    public String addSessionPage(Model model, @ModelAttribute("session") Session session){
        System.out.println("session + " + session);
        String email = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(email);
        User user = userOptional.get();
        session.setUser(user);
        sessionService.addNewSession(session);

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        System.out.println(userSessions);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);


        return "session.html";
    }

    /**
     * @param id
     * @param model
     * @return
     * Takes in a Model and PathVariable Id. 
     * Returns the update_session page populated with the session being updated. The correct session is retrieved using the pathvariable in the uri.
     */
    @GetMapping("/update/{id}")
    public String getUpdateSession(@PathVariable("id") Long id, Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        Session session = sessionService.getSessionById(id);

        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);

        return "update_session.html";
    }

    /**
     * @param id
     * @param update
     * @param model
     * @return
     * Takes the data from the update_session form, saves to the database, then grabs the Session, Spot, Surfboard, and Wave data and
     * renders that back to the session.html template that is returned. 
     */
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
        current.setComment(update.getComment());
        current.setDate(update.getDate());
        sessionService.addNewSession(current);

        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        User user = activeUser.get();

        int waveId = user.getId();
        Long longId = Long.valueOf(waveId);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);
        return "session.html";
    }

    /**
     * @param model
     * @param id
     * @return
     * Retrieves the id from the path variable and then deletes the session with that id. Then calls the Session, Surfboard, Spot and Wave data
     * to re-render the session.html page
     */
    @PostMapping("/delete/{id}")
    public String deleteSession(Model model, @PathVariable("id") Long id){
        System.out.println(id);
        sessionService.deleteSpot(id);
        String username = SessionAccess.getActiveUsername();
        Optional<User> activeUser = userService.findUserByEmail(username);
        User user = activeUser.get();

        int waveId = user.getId();
        Long longId = Long.valueOf(waveId);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.getSessionByUser(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);


        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);
        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by size descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page. 
     */
    @GetMapping("/sortbysizedesc")
    public String sortedBySizeDesc(Model model){
    String username = SessionAccess.getActiveUsername();
    Optional<User> userOptional = userService.findUserByEmail(username);
    User user = userOptional.get();

    List<Session> userSessions = sessionService.getOrderedSessionByUserDesc(user);
    List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
    List<Spot> userSpots = spotService.getSpotByUser(user);

    int id = user.getId();
    Long longId = Long.valueOf(id);
    Wave waveData = generateWaveData(longId);

    model.addAttribute("session", session);
    model.addAttribute("sessions", userSessions);
    model.addAttribute("surfboards", userSurfboards);
    model.addAttribute("spots", userSpots);
    model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by size ascending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbysizeasc")
    public String sortedBySizeAsc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.getOrderedSessionByUserAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by rating descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyratingdesc")
    public String sortedByRatingDesc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByUserByRatingDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by rating ascending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyratingasc")
    public String sortedByRatingAsc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByUserByRatingAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by board Descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyboardasc")
    public String sortedByBoardDesc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByBoardDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    
    /**
     * @param model
     * @return
     * Gets the session data sorted by size ascending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyboarddesc")
    public String sortedByBoardAsc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByBoardAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by spot descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyspotasc")
    public String sortedBySpotDesc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionBySpotDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by spot descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbyspotdesc")
    public String sortedBySpotAsc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionBySpotAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }

    /**
     * @param model
     * @return
     * Gets the session data sorted by Date descending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbydatedesc")
    public String sortedByDateDesc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByDateDesc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }
    
    /**
     * @param model
     * @return
     * Gets the session data sorted by Date ascending as well as the Surfboard, Spot and Wave data and reneders all to the page.
     * Returns the session.html page.
     */
    @GetMapping("/sortbydateasc")
    public String sortedByDateAsc(Model model){
        String username = SessionAccess.getActiveUsername();
        Optional<User> userOptional = userService.findUserByEmail(username);
        User user = userOptional.get();

        int id = user.getId();
        Long longId = Long.valueOf(id);
        Wave waveData = generateWaveData(longId);

        List<Session> userSessions = sessionService.orderSessionByDateAsc(user);
        List<Surfboard> userSurfboards = surfboardService.getSurfboardByUser(user);
        List<Spot> userSpots = spotService.getSpotByUser(user);

        model.addAttribute("session", session);
        model.addAttribute("sessions", userSessions);
        model.addAttribute("surfboards", userSurfboards);
        model.addAttribute("spots", userSpots);
        model.addAttribute("wavedata", waveData);

        return "session.html";
    }


    /**
     * @param id
     * @return
     * Gets the min, max, and average wave height across sessions for a user and stores them in a Wave object.
     * Returns the Wave object
     */
    public Wave generateWaveData(long id){
        try {
            Double maxWave = sessionService.getMaxWave(id);
            Double minWave = sessionService.getMinWave(id);
            Double avgWave = sessionService.getAvgWave(id);
            Wave waveData = new Wave(maxWave, minWave, avgWave);
            return waveData;
        } catch (NullPointerException e){
            Double maxWave = 0d;
            Double minWave = 0d;
            Double avgWave = 0d;
            Wave waveData = new Wave(maxWave, minWave, avgWave);
            return waveData;


        }

    }

}

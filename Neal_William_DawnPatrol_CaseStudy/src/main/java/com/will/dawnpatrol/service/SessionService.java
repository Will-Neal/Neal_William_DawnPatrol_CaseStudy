package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Session;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author willw
 * Injects the SpotRepository using constructor injection and then defines the logic for CRUD operations for Spots.
 * Contains 16 methods.
 * 
 */
@Service("sessionsService")
public class SessionService {

    private final SessionRepository sessionRepository;
    SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    /**
     * @param session
     * @return
     * Takes in a session and adds or updates it in the DB.
     */
    public Session addNewSession(Session session){
        return sessionRepository.save(session);
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that User.
     */
    public List<Session> getSessionByUser(User user){
        List<Session> userSessions = sessionRepository.findByUser(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by size desc. 
     */
    public List<Session> getOrderedSessionByUserDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySizeDesc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by size asc.
     */
    public List<Session> getOrderedSessionByUserAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySizeAsc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by Rating Desc.
     */
    public List<Session> orderSessionByUserByRatingDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByRatingDesc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by Rating Asc.
     */
    public List<Session> orderSessionByUserByRatingAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByRatingAsc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by board desc.
     */
    public List<Session> orderSessionByBoardDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByBoardDesc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by board asc.
     */
    public List<Session> orderSessionByBoardAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByBoardAsc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by spot desc.
     */
    public List<Session> orderSessionBySpotDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySpotDesc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by spot asc.
     */
    public List<Session> orderSessionBySpotAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySpotAsc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by date desc.
     */
    public List<Session> orderSessionByDateDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByDateDesc(user);
        return userSessions;
    }

    /**
     * @param user
     * @return
     * Takes in a User and returns a List of all Sessions associated with that user ordered by date asc.
     */
    public List<Session> orderSessionByDateAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByDateAsc(user);
        return userSessions;
    }


    /**
     * @param id
     * @return
     * Takes in an id and returns the Session associated with that id.
     */
    public Session getSessionById(Long id){
        Session session = sessionRepository.getReferenceById(id);
        return session;
    }

    /**
     * @param id
     * Takes in an id and deletes the Session associated with that id.
     */
    public void deleteSpot(Long id){
        sessionRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     * Takes in a User id and returns the Maximum size of a wave from all of the Sessions associated with that User.
     */
    public Double getMaxWave(Long id){
        Double wave = sessionRepository.findMaxWave(id);
        return wave;
    }

    /**
     * @param id
     * @return
     * Takes in a User id and returns the Minimum size of a wave from all of the Sessions associated with that User. 
     */
    public Double getMinWave(Long id){
        Double wave = sessionRepository.findMinWave(id);
        return wave;
    }

    /**
     * @param id
     * @return
     * Takes in a User id and returns the Average size of waves from all of the Sessions associated with that User.
     */
    public Double getAvgWave(Long id){
        Double wave = sessionRepository.findAvgWave(id);
        return wave;
    }
}

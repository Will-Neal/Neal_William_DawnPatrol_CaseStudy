package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Session;
import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionsService")
public class SessionService {

    private final SessionRepository sessionRepository;
    SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Session addNewSession(Session session){
        return sessionRepository.save(session);
    }

    public List<Session> getSessionByUser(User user){
        List<Session> userSessions = sessionRepository.findByUser(user);
        return userSessions;
    }

    public List<Session> getOrderedSessionByUserDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySizeDesc(user);
        return userSessions;
    }

    public List<Session> getOrderedSessionByUserAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySizeAsc(user);
        return userSessions;
    }

    public List<Session> orderSessionByUserByRatingDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByRatingDesc(user);
        return userSessions;
    }

    public List<Session> orderSessionByUserByRatingAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByRatingAsc(user);
        return userSessions;
    }

    public List<Session> orderSessionByBoardDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByBoardDesc(user);
        return userSessions;
    }

    public List<Session> orderSessionByBoardAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByBoardAsc(user);
        return userSessions;
    }

    public List<Session> orderSessionBySpotDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySpotDesc(user);
        return userSessions;
    }

    public List<Session> orderSessionBySpotAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderBySpotAsc(user);
        return userSessions;
    }

    public List<Session> orderSessionByDateDesc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByDateDesc(user);
        return userSessions;
    }

    public List<Session> orderSessionByDateAsc(User user){
        List<Session> userSessions = sessionRepository.findByUserOrderByDateAsc(user);
        return userSessions;
    }


    public Session getSessionById(Long id){
        Session session = sessionRepository.getReferenceById(id);
        return session;
    }

    public void deleteSpot(Long id){
        sessionRepository.deleteById(id);
    }

    public Double getMaxWave(Long id){
        Double wave = sessionRepository.findMaxWave(id);
        return wave;
    }

    public Double getMinWave(Long id){
        Double wave = sessionRepository.findMinWave(id);
        return wave;
    }

    public Double getAvgWave(Long id){
        Double wave = sessionRepository.findAvgWave(id);
        return wave;
    }
}

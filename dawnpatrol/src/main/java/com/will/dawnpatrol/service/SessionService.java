package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Session;
import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionsService")
public class SessionService {

    SessionRepository sessionRepository;
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

    public Session getSessionById(Long id){
        Session session = sessionRepository.getReferenceById(id);
        return session;
    }

    public void deleteSpot(Long id){
        sessionRepository.deleteById(id);
    }



}

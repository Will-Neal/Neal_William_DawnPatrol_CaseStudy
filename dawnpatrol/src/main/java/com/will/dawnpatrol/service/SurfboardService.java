package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SurfboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("surfboardService")
public class SurfboardService {

     SurfboardRepository surfboardRepository;
    //2nd method for injecting a bean(Constructor injection)
    @Autowired
    public SurfboardService(SurfboardRepository surfboardRepository){
        this.surfboardRepository = surfboardRepository;
    }

    public Surfboard addNewSurfboard(Surfboard surfboard){
        return surfboardRepository.save(surfboard);
    }

    public List<Surfboard> getSurfboardByUser(User user){
        List<Surfboard> userSurfboards = surfboardRepository.findByUser(user);
        return userSurfboards;
    }

    public void deleteSurfboard(int id){
        surfboardRepository.deleteById(id);
    }
}

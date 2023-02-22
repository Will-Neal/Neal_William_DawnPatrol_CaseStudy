package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SurfboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author willw
 * Injects the SurfboardRepository using constructor injection and then defines the logic for CRUD operations for Surfboards.
 * Contains 4 methods - addNewSurfboard, getSurfboardByUser, getSurfboardById, and deleteSurfboard.
 */
@Service("surfboardService")
public class SurfboardService {

    private final SurfboardRepository surfboardRepository;
    //2nd method for injecting a bean(Constructor injection)
    
    @Autowired
    public SurfboardService(SurfboardRepository surfboardRepository){
        this.surfboardRepository = surfboardRepository;
    }

    /**
     * @param surfboard
     * @return
     * Defines the logic for adding or updating a Surfboard.
     * Takes in a Surfboard and then adds or updates the database.
     * Returns the Surfboard that was added. 
     */
    public Surfboard addNewSurfboard(Surfboard surfboard){
        return surfboardRepository.save(surfboard);
    }

    /**
     * @param user
     * @return
     * Takes in a User and gets the list of Surfboards associated with that User. 
     * Returns the list of Surfboards.
     */
    public List<Surfboard> getSurfboardByUser(User user){
        List<Surfboard> userSurfboards = surfboardRepository.findByUser(user);
        return userSurfboards;
    }

    /**
     * @param id
     * @return
     * Takes in an id and gets the Surfboard with that id and returns it.
     */
    public Surfboard getSurfboardById(int id){
        Surfboard surfboard = surfboardRepository.getReferenceById(id);
        return surfboard;
    }

    /**
     * @param id
     * Takes in an id and then deletes the Surfboard with that id.
     */
    public void deleteSurfboard(int id){
        surfboardRepository.deleteById(id);
    }
}

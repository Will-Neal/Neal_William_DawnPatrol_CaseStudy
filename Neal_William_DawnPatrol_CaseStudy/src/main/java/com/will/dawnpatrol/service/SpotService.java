package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author willw
 * Injects the SpotRepository using constructor injection and then defines the logic for CRUD operations for Spots.
 * Contains 4 methods - addNewSpot, getSpotByUser, getSpotById, and deleteSpot.
 */
@Service("spotService")
public class SpotService {

    private final SpotRepository spotRepository;
    
    SpotService(SpotRepository spotRepository){
        this.spotRepository = spotRepository;
    }

    /**
     * @param spot
     * @return
     * Defines the logic for adding or updating a Spot.
     * Takes in a Spot and then adds or updates the database.
     * Returns the spot that was added. 
     */
    public Spot addNewSpot(Spot spot){
        return spotRepository.save(spot);
    }

    /**
     * @param user
     * @return
     * Takes in a User and gets the list of Spots associated with that User. 
     * Returns the list of Spots. 
     */
    public List<Spot> getSpotByUser(User user){
        List<Spot> userSpots = spotRepository.findByUser(user);
        return userSpots;
    }

    /**
     * @param id
     * @return
     * Takes in an id and gets the Spot with that id and returns it. 
     */
    public Spot getSpotById(int id){
        Spot spot = spotRepository.getReferenceById(id);
        return spot;
    }

    /**
     * @param id
     * Takes in an id and then deletes the spot with that id.
     */
    public void deleteSpot(int id){
        spotRepository.deleteById(id);
    }

}

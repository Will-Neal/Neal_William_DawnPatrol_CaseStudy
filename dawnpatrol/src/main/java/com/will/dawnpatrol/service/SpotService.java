package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("spotService")
public class SpotService {

    private final SpotRepository spotRepository;
    SpotService(SpotRepository spotRepository){
        this.spotRepository = spotRepository;
    }

    public Spot addNewSpot(Spot spot){
        return spotRepository.save(spot);
    }

    public List<Spot> getSpotByUser(User user){
        List<Spot> userSpots = spotRepository.findByUser(user);
        return userSpots;
    }

    public Spot getSpotById(int id){
        Spot spot = spotRepository.getReferenceById(id);
        return spot;
    }

    public void deleteSpot(int id){
        spotRepository.deleteById(id);
    }

}

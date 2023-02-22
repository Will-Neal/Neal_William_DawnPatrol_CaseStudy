package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Spot;

import java.util.List;

/**
 * @author willw
 * Repository that sets the contract for the SpotService. 
 * Only contains one method - findByUser, which is used to retrieve all of the Spots associated with the given User. 
 */
@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{
    List<Spot> findByUser(User user);
}

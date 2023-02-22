package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Surfboard;

import java.util.List;

/**
 * @author willw
 * Repository that sets the contract for the SurfboardService. 
 * Only contains one method - findByUser, which is used to retrieve all of the Surfboards associated with the given User. 
 */
@Repository
public interface SurfboardRepository extends JpaRepository<Surfboard, Integer>{
    List<Surfboard> findByUser(User user);
}

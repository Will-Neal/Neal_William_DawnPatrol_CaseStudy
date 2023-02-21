package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Spot;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{
    List<Spot> findByUser(User user);
}

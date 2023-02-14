package com.will.dawnpatrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Spot;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{

}

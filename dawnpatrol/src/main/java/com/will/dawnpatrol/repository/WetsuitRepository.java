package com.will.dawnpatrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Wetsuit;

@Repository
public interface WetsuitRepository extends JpaRepository<Wetsuit, Integer> {

}

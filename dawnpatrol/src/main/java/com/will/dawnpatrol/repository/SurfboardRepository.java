package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Surfboard;

import java.util.List;

@Repository
public interface SurfboardRepository extends JpaRepository<Surfboard, Integer>{
    List<Surfboard> findByUser(User user);
}

package com.will.dawnpatrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Sessions;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Long>{

}

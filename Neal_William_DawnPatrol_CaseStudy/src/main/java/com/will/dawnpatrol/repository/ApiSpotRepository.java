package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author willw
 * Creates a rest enpoint at /spots that can be utilized to get surfboard data.
 */
@RepositoryRestResource(path = "spots")
public interface ApiSpotRepository extends JpaRepository<Spot, Integer> {


}
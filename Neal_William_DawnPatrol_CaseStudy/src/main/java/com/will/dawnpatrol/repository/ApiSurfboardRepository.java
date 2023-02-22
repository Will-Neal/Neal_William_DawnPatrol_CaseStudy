package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Surfboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author willw
 * Creates a rest enpoint at /surfboards that can be utilized to get surfboard data. 
 */
@RepositoryRestResource(path = "surfboards")
public interface ApiSurfboardRepository extends JpaRepository<Surfboard, Integer> {


}

package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Surfboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "surfboards")
public interface ApiSurfboardRepository extends JpaRepository<Surfboard, Integer> {


}

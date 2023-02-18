package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Session;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

    List<Session> findByUser(User user);
    List<Session> findByUserOrderBySizeDesc(User user);
    List<Session> findByUserOrderBySizeAsc(User user);
    List<Session> findByUserOrderByRatingDesc(User user);
    List<Session> findByUserOrderByRatingAsc(User user);

    List<Session> findByUserOrderByBoardDesc(User user);

    List<Session> findByUserOrderByBoardAsc(User user);

    List<Session> findByUserOrderBySpotDesc(User user);

    List<Session> findByUserOrderBySpotAsc(User user);



}

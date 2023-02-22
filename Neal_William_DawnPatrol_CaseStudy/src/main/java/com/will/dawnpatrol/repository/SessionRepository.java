package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.will.dawnpatrol.model.Session;

import java.util.List;

/**
 * @author willw
 * Sets the contract for all of the methods that are implemented in the SessionService. 
 * All of the findBy methods are used for returning all the data by User in different orders based on the order by clause.
 * This is used for filtering Sessions on the sessions page.
 * Min, Max, and Average methods are used for getting User metrics. They are called by the GenerateWaveData function in the SessionsController.
 */
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

    List<Session> findByUserOrderByDateDesc(User user);

    List<Session> findByUserOrderByDateAsc(User user);

    @Query(value = "SELECT MAX(size) FROM session s Where s.user_id = :id", nativeQuery = true)
    Double findMaxWave(@Param("id") Long id);

    @Query(value = "SELECT MIN(size) FROM session s Where s.user_id = :id", nativeQuery = true)
    Double findMinWave(@Param("id") Long id);

    @Query(value = "SELECT AVG(size) FROM session s Where s.user_id = :id", nativeQuery = true)
    Double findAvgWave(@Param("id") Long id);

}

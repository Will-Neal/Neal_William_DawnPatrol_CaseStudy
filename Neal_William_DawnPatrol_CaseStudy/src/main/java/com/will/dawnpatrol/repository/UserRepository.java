package com.will.dawnpatrol.repository;




import com.will.dawnpatrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author willw
 * Repository that sets the contract for the UserService. 
 * Only contains one method - findByEmail, which is used to retrieve all of the user details associated with the User with the given email.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}

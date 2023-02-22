package com.will.dawnpatrol.service;


import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author willw
 * Injects the UserRepository using constructor injection and then defines the logic for CRUD operations for Users.
 * Contains 5 methods - getAllUsers, getUserById, addNewUser, checkUnique and findUserByEmail.
 */
@Service("userService")
public class UserService {

    //1st method for injecting a bean(Field injection)
    @Autowired
    private UserRepository userRepository;


    /**
     * @return
     * Gets all Users from DB and returns the list.
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * @param id
     * @return
     * Takes in an id and returns the User with that id.
     */
    public User getUserById(int id){
        return userRepository.getReferenceById(id);
    }

    /**
     * @param user
     * @param encoder
     * @return
     * Takes in a User and PasswordEncoder, uses the PasswordEncoder to hash the password, overwrites the plain text password and saves to DB.
     * Returns the User that was saved to the DB.
     */
    public User addNewUser(User user, PasswordEncoder encoder){
        String plainPassword = user.getPassword();
        String hashPassword = encoder.encode(plainPassword);
        user.setPassword(hashPassword);


        return userRepository.save(user);
    }

    /**
     * @param email
     * @return
     * Takes in an email and checks if that email exists in the database. 
     * If the email does not exist in the DB it returns true, if it does it returns false. 
     */
    public Boolean checkUnique(String email){
        //System.out.println("check unique function " + userRepository.findByEmail(email));
        if(userRepository.findByEmail(email).isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param email
     * @return
     * Takes in an email, finds the User with that email and returns that User and their data. 
     */
    public Optional<User> findUserByEmail(String email){
        Optional<User> singleUser = userRepository.findByEmail(email);
        return singleUser;
    }


}

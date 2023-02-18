package com.will.dawnpatrol.service;


import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {

    //1st method for injecting a bean(Field injection)
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.getReferenceById(id);
    }

    public User addNewUser(User user, PasswordEncoder encoder){
        String plainPassword = user.getPassword();
        String hashPassword = encoder.encode(plainPassword);
        user.setPassword(hashPassword);


        return userRepository.save(user);
    }

    public Boolean checkUnique(String email){
        //System.out.println("check unique function " + userRepository.findByEmail(email));
        if(userRepository.findByEmail(email).isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    public Optional<User> findUserByEmail(String email){
        Optional<User> singleUser = userRepository.findByEmail(email);
        return singleUser;
    }


}

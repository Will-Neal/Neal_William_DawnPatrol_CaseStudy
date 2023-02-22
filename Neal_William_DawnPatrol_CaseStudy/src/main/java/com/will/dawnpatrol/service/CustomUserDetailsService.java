package com.will.dawnpatrol.service;

import com.will.dawnpatrol.model.AuthUser;
import com.will.dawnpatrol.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author willw
 * Defines the UserDetailsService that is used in the SecurityChainFilter.
 * Contains 1 method, loadUserByUsername, which overrides the method and defines the database logic for User auth.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Overrides the method to take in a user name, get the user with that username from the database and then maps that user to an AuthUser.
     * Throws UsernameNotFoundException if the username does not exist in the DB. 
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByEmail(username)
                .map(AuthUser::new)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found: " + username));
    }
}

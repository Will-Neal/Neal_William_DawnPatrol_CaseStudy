package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.service.CustomUserDetailsService;
import com.will.dawnpatrol.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

/**
 * @author willw
 * JUnit 4 test for the CustomUserDetailService.
 * Tests the service by testing the method LoadUserByName which is the only method added in the repository. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestCustomUserDetailService {

    @Autowired
    CustomUserDetailsService cuds;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    /**
     * Tests the LoadUserByUSername function by creating a test User, saving that user to the DB,then using the method to retrieve that user for Auth purposes.
     * A Property is checked to match in order to pass. 
     */
    @Test
    public void TestLoadUserByUsername(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userService.addNewUser(testUser, passwordEncoder);
        Optional<User> userOptional = userService.findUserByEmail("x@1!hG0a@example.com");
        User user = userOptional.get();

        UserDetails functionUser = cuds.loadUserByUsername("x@1!hG0a@example.com");
        String expected = "x@1!hG0a@example.com";
        String actual = functionUser.getUsername();

        userRepository.deleteById(user.getId());

        assertEquals(expected, actual);

    }
}

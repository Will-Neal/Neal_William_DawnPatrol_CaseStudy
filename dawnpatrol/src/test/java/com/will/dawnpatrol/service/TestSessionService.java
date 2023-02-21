package com.will.dawnpatrol.service;


import com.will.dawnpatrol.model.Session;
import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.Surfboard;
import com.will.dawnpatrol.model.User;
import com.will.dawnpatrol.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSessionService {

    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Test
    public void TestAddNewSession(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userService.addNewUser(testUser, passwordEncoder);
        Optional<User> userOptional = userService.findUserByEmail("x@1!hG0a@example.com");
        User user = userOptional.get();

        Session expected = new Session();
        expected.setUser(user);
        expected.setDate("testDate");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        sessionService.addNewSession(expected);

        List<Session> sessionList = sessionService.getSessionByUser(user);

        String actualName = sessionList.get(0).getBoard();
        String expectedName = expected.getBoard();

        userRepository.deleteById(testUser.getId());

        assertEquals(expectedName, actualName);
    }
}
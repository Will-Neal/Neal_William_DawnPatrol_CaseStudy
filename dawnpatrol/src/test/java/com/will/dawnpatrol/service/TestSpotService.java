package com.will.dawnpatrol.service;


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
public class TestSpotService {

    @Autowired
    UserService userService;

    @Autowired
    SpotService spotService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Test
    public void TestAddNewSpot(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userService.addNewUser(testUser, passwordEncoder);
        Optional<User> userOptional = userService.findUserByEmail("x@1!hG0a@example.com");
        User user = userOptional.get();

        Spot expected = new Spot();
        expected.setUser(user);
        expected.setName("testName");
        expected.setType("testType");
        expected.setLocation("testLocation");
        expected.setIdealExposure("testExposure");
        expected.setIdealWind("testWind");
        spotService.addNewSpot(expected);

        List<Spot> spotList = spotService.getSpotByUser(user);

        String actualName = spotList.get(0).getName();
        String expectedName = expected.getName();

        userRepository.deleteById(testUser.getId());

        assertEquals(expectedName, actualName);
    }
}
package com.will.dawnpatrol.service;


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
public class TestSurfboardService {

    @Autowired
    UserService userService;

    @Autowired
    SurfboardService surfboardService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Test
    public void TestAddNewSurfboard(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userService.addNewUser(testUser, passwordEncoder);
        Optional<User> userOptional = userService.findUserByEmail("x@1!hG0a@example.com");
        User user = userOptional.get();

        Surfboard expected = new Surfboard();
        expected.setUser(user);
        expected.setShaper("testShaper");
        expected.setLength("testLength");
        expected.setTail("testTail");
        expected.setFinNum(4);
        expected.setFinType("testFinType");

        surfboardService.addNewSurfboard(expected);
        List<Surfboard> surfboardList = surfboardService.getSurfboardByUser(user);

        String actualShaper = surfboardList.get(0).getShaper();
        String expectedShaper = expected.getShaper();

        userRepository.deleteById(testUser.getId());

        assertEquals(expectedShaper, actualShaper);

    }
}
package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Spot;
import com.will.dawnpatrol.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSpotRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpotRepository spotRepository;



    @Test
    public void TestFindByUser(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Spot expected = new Spot();
        expected.setUser(testUserObj);
        expected.setName("testName");
        expected.setType("testType");
        expected.setLocation("testLocation");
        expected.setIdealExposure("testExposure");
        expected.setIdealWind("testWind");

        spotRepository.save(expected);

        List<Spot> actual = spotRepository.findByUser(testUserObj);
        Spot spot = actual.get(0);

        String expectedName = spot.getName();
        String actualName = expected.getName();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedName, actualName);
    }
}
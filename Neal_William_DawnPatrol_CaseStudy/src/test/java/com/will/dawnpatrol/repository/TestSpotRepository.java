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

/**
 * @author willw
 * Junit 4 test for the Spot Repository. 
 * Tests the FindByUser method which is the only custom method defined in the repository.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSpotRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpotRepository spotRepository;



    /**
     * Test the findByUser method. Creates a user saves to database and retrieves that user for database.
     * Then creates a Spot and associates it with the test User. The spotRepository is used to find by User and checked against the original Spot object saved.
     */
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
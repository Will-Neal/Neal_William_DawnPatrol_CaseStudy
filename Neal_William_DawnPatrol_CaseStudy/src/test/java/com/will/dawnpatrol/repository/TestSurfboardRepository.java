package com.will.dawnpatrol.repository;


import com.will.dawnpatrol.model.Surfboard;
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
 * Junit 4 test for the Surfboard Repository. 
 * Tests the FindByUser method which is the only custom method defined in the repository.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSurfboardRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SurfboardRepository surfboardRepository;

    /**
     * Test the findByUser method. Creates a user saves to database and retrieves that user for database.
     * Then creates a Surfboard and associates it with the test User. The surfboardRepository is used to find by User and checked against the original Surfboard object saved.
     */
    @Test
    public void TestFindByUser(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Surfboard expected = new Surfboard();
        expected.setUser(testUserObj);
        expected.setShaper("testShaper");
        expected.setLength("testLength");
        expected.setTail("testTail");
        expected.setFinNum(4);
        expected.setFinType("testFinType");

        surfboardRepository.save(expected);

        List<Surfboard> actual = surfboardRepository.findByUser(testUserObj);
        Surfboard surfboard = actual.get(0);

        String expectedShaper = surfboard.getShaper();
        String actualShaper = expected.getShaper();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedShaper, actualShaper);
    }
}

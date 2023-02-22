package com.will.dawnpatrol.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author willw
 * JUnit 4 test for the UserService class.
 * Tests the checkUnique method.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserService {

    @Autowired
    UserService userService;

    /**
     * Provides an email that we know is not in the database and checks the result against the expected.
     * The checkUnique function will return true when the email does not exist in the database so we expect true.
     */
    @Test
    public void TestCheckUnique() {
        boolean expected = true;
        boolean actual = userService.checkUnique("x!#g4123@8hBtYv@3$5%31123.com");


        assertEquals(expected, actual);

    }
}

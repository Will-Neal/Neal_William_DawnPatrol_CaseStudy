package com.will.dawnpatrol.service;


import com.will.dawnpatrol.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserService {

    @Autowired
    UserService userService;

    @Test
    public void TestCheckUnique(){
        boolean expected = true;
        boolean actual = userService.checkUnique("x!#g4123@8hBtYv@3$5%31123.com");



        assertEquals(expected, actual);

    }
}

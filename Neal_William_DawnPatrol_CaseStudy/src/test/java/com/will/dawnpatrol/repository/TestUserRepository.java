package com.will.dawnpatrol.repository;


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
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    public void TestFindByEmail(){
            User expected = new User();
            expected.setEmail("x@1!hG0a@example.com");
            expected.setPassword("password123");

            userRepository.save(expected);

            Optional<User> actualOptional = userRepository.findByEmail("x@1!hG0a@example.com");
            User actual = actualOptional.get();
            String expectedEmail = expected.getEmail();
            String actualEmail = actual.getEmail();
            int id = actual.getId();
            userRepository.deleteById(id);
            assertEquals(expectedEmail, actualEmail);

    }
}

package com.will.dawnpatrol.repository;

import com.will.dawnpatrol.model.Session;
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
public class TestSessionRepository {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;



    @Test
    public void TestFindByUser(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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


        sessionRepository.save(expected);

        List<Session> actual = sessionRepository.findByUser(testUserObj);
        Session session = actual.get(0);

        Double expectedSize = session.getSize();
        Double actualSize = expected.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderBySizeDesc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(5);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderBySizeDesc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = expected.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderBySizeAsc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(5);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderBySizeAsc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = secondSession.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByRatingDesc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");

        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByRatingDesc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = expected.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByRatingAsc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByRatingAsc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = secondSession.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByBoardDesc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByBoardDesc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = expected.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByBoardAsc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByBoardAsc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = secondSession.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderBySpotDesc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderBySpotDesc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = expected.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderBySpotAsc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
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

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("SecondDate");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderBySpotAsc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = secondSession.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByDateDesc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
        expected.setDate("2023-02-19");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("2001-02-19");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByDateDesc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = expected.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindByUserOrderByDateAsc(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
        expected.setDate("2023-02-19");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("2001-02-19");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);

        List<Session> actualList = sessionRepository.findByUserOrderByDateAsc(testUserObj);
        Session actual = actualList.get(0);


        Double expectedSize = secondSession.getSize();
        Double actualSize = actual.getSize();

        int id = testUserObj.getId();
        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindMaxWave(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
        expected.setDate("2023-02-19");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("2001-02-19");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);
        int id = testUserObj.getId();
        Long longId = Long.valueOf(id);
        Double maxWave = sessionRepository.findMaxWave(longId);

        Double expectedSize = 6.0d;
        Double actualSize = maxWave;



        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindMinWave(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
        expected.setDate("2023-02-19");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("2001-02-19");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);
        int id = testUserObj.getId();
        Long longId = Long.valueOf(id);
        Double maxWave = sessionRepository.findMinWave(longId);

        Double expectedSize = 1.0d;
        Double actualSize = maxWave;



        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestFindAvgWave(){
        User testUser = new User();
        testUser.setEmail("x@1!hG0a@example.com");
        testUser.setPassword("password123");
        userRepository.save(testUser);

        Optional<User> testUserOptional = userRepository.findByEmail("x@1!hG0a@example.com");
        User testUserObj = testUserOptional.get();

        Session expected = new Session();
        expected.setUser(testUserObj);
        expected.setDate("2023-02-19");
        expected.setComment("testComment");
        expected.setRating(5);
        expected.setSpot("testSpot");
        expected.setBoard("testBoard");
        expected.setPeriod(8);
        expected.setWindStrength(20);
        expected.setWindDirection(123);
        expected.setSize(6.0);
        expected.setDirection(360);

        Session secondSession = new Session();
        secondSession.setUser(testUserObj);
        secondSession.setDate("2001-02-19");
        secondSession.setComment("SecondComment");
        secondSession.setRating(1);
        secondSession.setSpot("SecondSpot");
        secondSession.setBoard("SecondBoard");
        secondSession.setPeriod(8);
        secondSession.setWindStrength(20);
        secondSession.setWindDirection(123);
        secondSession.setSize(1.0);
        secondSession.setDirection(360);


        sessionRepository.save(expected);
        sessionRepository.save(secondSession);
        int id = testUserObj.getId();
        Long longId = Long.valueOf(id);
        Double maxWave = sessionRepository.findAvgWave(longId);

        Double expectedSize = 3.5d;
        Double actualSize = maxWave;



        userRepository.deleteById(id);

        assertEquals(expectedSize, actualSize);
    }
}
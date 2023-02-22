package com.will.dawnpatrol.controller;


import com.will.dawnpatrol.model.Wave;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;


/**
 * @author willw
 * JUnit 5 Parameterized test that tests the SessionController.
 * Specifically tests the GenerateWaveData method.
 */
@SpringBootTest
public class TestSessionController {

    @Autowired
    SessionController sessionController;

    /**
     * @param number
     * Takes in a parameter and passes that as an id to the generateWaveData function.
     * Since this number is an impossibility in the db it should return a null result and trigger the catch block in the function returning a WaveData with all properties set to 0.
     * This tests what happens what a User creates a new page and signs into the website for the first time, which was previously causing errors. 
     */
    @ParameterizedTest
    @ValueSource(longs = {0L})
    public void testGenerateWaveData(Long number){
        Wave expected = new Wave(0L, 0L, 0L);
        Wave actual = sessionController.generateWaveData(number);

        assertEquals(expected, actual);

    }
}

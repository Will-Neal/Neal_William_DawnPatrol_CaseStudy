package com.will.dawnpatrol.controller;


import com.will.dawnpatrol.model.Wave;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
@SpringBootTest
public class TestSessionController {

    @Autowired
    SessionController sessionController;

//    @Test
    @ParameterizedTest
    @ValueSource(longs = {0L})
    public void testGenerateWaveData(Long number){
        Wave expected = new Wave(0L, 0L, 0L);
        Wave actual = sessionController.generateWaveData(number);

        assertEquals(expected, actual);

    }
}

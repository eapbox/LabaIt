package com.gmail.eapbox.laba;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by eapbox on 30.01.2018.
 */
public class CompetitionTest {
    private CompetitionImpl competition;

    @Before
    public void setUp() throws Exception {
        competition = new CompetitionImpl();
    }

    @Test
    public void setValidTask() throws ValidateException {
        competition.getSteps("0");
        competition.getSteps("1");
        competition.getSteps("2");
        competition.getSteps("2 0 7");
        competition.getSteps("2 0    7 3");
        competition.getSteps("2 0    7 3  ");
    }

    @Test(expected = ValidateException.class)
    public void setTaskNulException() throws ValidateException {
        competition.getSteps("");
    }

    @Test(expected = ValidateException.class)
    public void setTaskLatException() throws ValidateException {
        competition.getSteps("sdsdgf");
    }

    @Test(expected = ValidateException.class)
    public void setTaskMixException() throws ValidateException {
        competition.getSteps("2 0 7d");
    }

    @Test
    public void getFirstStepsForward() throws Exception {
        int actual = competition.getSteps("3 0 7 8");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void getFirstStepsBehind() throws Exception {
        int actual = competition.getSteps("6 2");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void getSteps1() throws Exception {
        int actual = competition.getSteps("2 0 7");
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void getSteps2() throws Exception {
        int actual = competition.getSteps("2 0 2 5 7");
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void getSteps3() throws Exception {
        int actual = competition.getSteps("2 0 2 6 7");
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void getSteps4() throws Exception {
        int actual = competition.getSteps("2 0 2 0 0 4 0 3");
        int expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    public void getSteps5() throws Exception {
        int actual = competition.getSteps("2 0 3 0 0 5 0 3");
        int expected = 4;
        assertEquals(expected, actual);
    }
}
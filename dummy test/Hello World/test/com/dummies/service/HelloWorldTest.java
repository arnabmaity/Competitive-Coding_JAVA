package com.dummies.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {
    Solver solver;

    @Before
    public void setUp(){
        solver = new Solver();
    }

    @Test
    public void test(){
        assertEquals("Addition result = "+12,solver.solve(5,7));
    }
}
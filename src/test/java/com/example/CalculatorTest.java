package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator(); //steg 1, 2 och 3


    @Test
    public void testAddingTwoNumbers() {
        Assertions.assertEquals(5, calculator.add(2, 3));
//commit: steg 1
    }
}

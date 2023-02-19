package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator(); //steg 1, 2 och 3

@Test
    public void testingAddingMoreNumbers() {
    Assertions.assertEquals(10, calculator.add(2, 3, 5));
}
@Test
    public void testingAddingMoreNumbersMoreItems(){
        Assertions.assertEquals(15, calculator.add(2,3,5,5));
        }
        //Commit: steg 2
}

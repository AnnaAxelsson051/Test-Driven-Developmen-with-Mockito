package com.example;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CalculatorTest {
    private Calculator calculator = new Calculator(); //steg 1, 2 och 3

    @Test
    public void testAddElementsFromList(){
        Assertions.assertEquals(10, calculator.add(Lists.list(2,3,4,1)));
    }
    @Test
    public void testAddElementsFromEmptyListShouldReturn0(){
        Assertions.assertEquals(0, calculator.add(new ArrayList<>()));
    }
    @Test
    public void testAddingElementsFromNullShouldThrowException(){
        Assertions.assertThrows(RuntimeException.class, () -> calculator.add(null));
//Commit steg 3
    }
}

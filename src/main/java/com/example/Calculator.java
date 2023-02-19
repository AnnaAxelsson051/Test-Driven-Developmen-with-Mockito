package com.example;

public class Calculator {

    public int add(int number, int number1, int... others) {
        int firstSum = number + number1;
        for (int i : others) {
            firstSum += i;
        }
        return firstSum;
    }
    //commit: steg 2
}

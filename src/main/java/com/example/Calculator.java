package com.example;

import java.util.List;

public class Calculator {

    public int add(List<Integer> items) {
        if (items != null) { //throw exception
            Integer firstSum = 0;
            for (int i : items) {
                firstSum += i;
            }
            return firstSum;
        }else{
            throw new RuntimeException("Can not be null");
        }
    }
}

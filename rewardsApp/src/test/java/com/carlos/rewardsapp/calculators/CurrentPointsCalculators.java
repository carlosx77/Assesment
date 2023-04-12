package com.carlos.rewardsapp.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CurrentPointsCalculators {

    @Test
    void testCalculatePoints() {
        CurrentPointsCalculator calculator = new CurrentPointsCalculator();

        // Test case 1
        int points1 = calculator.calculatePoints(new BigDecimal("40"));
        assertEquals(0, points1);

        // Test case 2
        int points2 = calculator.calculatePoints(new BigDecimal("80"));
        assertEquals(30, points2);

        // Test case 3
        int points3 = calculator.calculatePoints(new BigDecimal("150"));
        assertEquals(150, points3);

        // Test case 4
        int points4 = calculator.calculatePoints(new BigDecimal("250"));
        assertEquals(350, points4);
        
        // Test case 4
        int points5 = calculator.calculatePoints(new BigDecimal("120"));
        assertEquals(90, points5);
    }
}
package com.carlos.rewardsapp.calculators;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrentPointsCalculator implements ICalculators {
	public int calculatePoints(BigDecimal amount) {
	    int points = 0;
	    BigDecimal limit1 = new BigDecimal("50");
	    BigDecimal limit2 = new BigDecimal("100");

	    if (amount.compareTo(limit2) > 0) {
	        points += 2 * (amount.subtract(limit2)).intValue();
	        amount = limit2;
	    }
	    if (amount.compareTo(limit1) > 0) {
	        points += (amount.subtract(limit1)).intValue();
	    }

	    return points;
	}
}

package com.carlos.rewardsapp.service;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.rewardsapp.calculators.ICalculators;
import com.carlos.rewardsapp.dao.TransactionsDAO;
import com.carlos.rewardsapp.dto.PointsPerMonth;
import com.carlos.rewardsapp.dto.PointsPerYear;
import com.carlos.rewardsapp.entities.Transaction;

@Service
public class RewardsService implements IRewardsService {
	
	@Autowired
	TransactionsDAO rewardPointsRepo;
	
	@Autowired
	ICalculators calculator;

	public PointsPerYear getRewardPoints(Long customerId, Integer year) {
		List<Transaction> points = rewardPointsRepo.findByCustomerIdAndYear(customerId, year);
		return getPointsPerYearAndMonth(points, year);
	}
	
	private PointsPerYear getPointsPerYearAndMonth(List<Transaction> transactions, Integer year) {
	    Map<Month, Integer> pointsPerMonth = transactions.stream()
	            .collect(Collectors.groupingBy(
	                    t -> t.getTimestamp().getMonth(),
	                    Collectors.reducing(0, t -> calculator.calculatePoints(t.getAmount()), Integer::sum)
	            ));

	    int pointsPerYear = pointsPerMonth.values().stream().reduce(0, Integer::sum);

	    List<PointsPerMonth> pointsList = pointsPerMonth.entrySet().stream()
	            .map(entry -> new PointsPerMonth(entry.getKey(), entry.getValue()))
	            .sorted(Comparator.comparingInt(ppm -> ppm.getMonth().getValue()))
	            .collect(Collectors.toList());

	    return new PointsPerYear(year, pointsList, pointsPerYear);		
	}
}

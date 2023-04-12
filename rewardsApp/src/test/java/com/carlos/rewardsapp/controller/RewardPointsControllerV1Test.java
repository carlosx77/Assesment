package com.carlos.rewardsapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carlos.rewardsapp.dto.PointsPerMonth;
import com.carlos.rewardsapp.dto.PointsPerYear;
import com.carlos.rewardsapp.service.RewardsService;

@ExtendWith(MockitoExtension.class)
public class RewardPointsControllerV1Test {
    @Mock
    private RewardsService rewardsService;

    @InjectMocks
    private RewardPointsControllerV1 rewardPointsController;

    @Test
    void getRewardPointsForMonth_returnsNotFound_whenNoPointsExist() {
        Long customerId = 1L;
        Integer year = 2022;

        when(rewardsService.getRewardPoints(customerId, year)).thenReturn(null);

        ResponseEntity<PointsPerYear> response = rewardPointsController.getRewardPointsForMonth(customerId, year);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getRewardPointsForMonth_returnsPointsPerYear_whenPointsExist() {
        Long customerId = 1L;
        Integer year = 2022;

        PointsPerYear expectedPointsPerYear = new PointsPerYear();
        expectedPointsPerYear.setYear(year);

        List<PointsPerMonth> pointsPerMonthList = new ArrayList<>();

        PointsPerMonth januaryPoints = new PointsPerMonth();
        januaryPoints.setMonth(Month.JANUARY);
        januaryPoints.setPointsPerMonth(10);
        pointsPerMonthList.add(januaryPoints);

        PointsPerMonth februaryPoints = new PointsPerMonth();
        februaryPoints.setMonth(Month.FEBRUARY);
        februaryPoints.setPointsPerMonth(15);
        pointsPerMonthList.add(februaryPoints);

        expectedPointsPerYear.setPointsPerMonth(pointsPerMonthList);

        BigDecimal totalPoints = new BigDecimal(25);
        expectedPointsPerYear.setPointsPerYear(totalPoints.intValue());

        when(rewardsService.getRewardPoints(customerId, year)).thenReturn(expectedPointsPerYear);

        ResponseEntity<PointsPerYear> response = rewardPointsController.getRewardPointsForMonth(customerId, year);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPointsPerYear, response.getBody());
    }
}
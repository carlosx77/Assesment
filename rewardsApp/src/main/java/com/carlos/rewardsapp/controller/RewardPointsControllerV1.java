package com.carlos.rewardsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.rewardsapp.dto.PointsPerYear;
import com.carlos.rewardsapp.service.RewardsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/v1/reward-points")
@Api("REST API to get rewards")
public class RewardPointsControllerV1 {
	

	   @Autowired
	   private RewardsService rewardsService;

	   @ApiOperation(value="Obtains the rewards for a given customerId and a given year", 
			   notes = "Returns points per year and a list of points per month",
			   response = PointsPerYear.class)
	   
	   @GetMapping("rewards/{customerId}/{year}")
	   public ResponseEntity<PointsPerYear> getRewardPointsForMonth(
	           @PathVariable Long customerId,
	           @PathVariable Integer year) {
		   PointsPerYear rewardPoints = rewardsService.getRewardPoints(customerId, year);
	       if (rewardPoints == null) {
	           return ResponseEntity.notFound().build();
	       }
	       return ResponseEntity.ok(rewardPoints);
	   }
}

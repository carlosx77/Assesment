package com.carlos.rewardsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.rewardsapp.dto.PointsPerYear;
import com.carlos.rewardsapp.service.RewardsService;

@RestController
@RequestMapping("/api/v1/reward-points")
public class RewardPointsControllerV1 {
	

	   @Autowired
	   private RewardsService rewardsService;
	   
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

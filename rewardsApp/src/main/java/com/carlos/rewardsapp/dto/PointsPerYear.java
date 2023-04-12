package com.carlos.rewardsapp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PointsPerYear {
	int year;
	List<PointsPerMonth> pointsPerMonth;
	int pointsPerYear;
}

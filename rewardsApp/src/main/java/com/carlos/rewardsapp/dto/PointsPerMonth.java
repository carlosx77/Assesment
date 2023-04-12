package com.carlos.rewardsapp.dto;

import java.time.Month;

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
public class PointsPerMonth {
	Month month;
	int pointsPerYear;
}

package com.carlos.rewardsapp.dto;

import java.time.Month;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Dto that contains earned points per month")
public class PointsPerMonth {
	@ApiModelProperty("Month of the year")
	Month month;
	@ApiModelProperty("Requested year")
	int pointsPerMonth;
}

package com.carlos.rewardsapp.dto;

import java.util.List;

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
@ApiModel("Dto that contains earned points per year and a list of points per month")
public class PointsPerYear {
	@ApiModelProperty("Requested year")
	int year;
	@ApiModelProperty("List of points per mothn")
	List<PointsPerMonth> pointsPerMonth;
	@ApiModelProperty("Total of points for the given year")
	int pointsPerYear;
}

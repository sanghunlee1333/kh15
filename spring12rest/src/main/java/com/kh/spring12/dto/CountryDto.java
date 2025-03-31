package com.kh.spring12.dto;

import lombok.Data;

@Data
public class CountryDto {
	private Long countryNo;
	private String countryName;
	private String countryCapital;
	private Long countryPopulation;
}
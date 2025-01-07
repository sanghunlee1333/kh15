package com.kh.spring06.dto;

public class CountryDto {
	private int countryNo;
	private String countryName;
	private String countryCapital;
	private long countryPopulation;
	
	public int getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(int countryNo) {
		this.countryNo = countryNo;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public long getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(long countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	
	@Override
	public String toString() {
		return "CountryDto [countryNo=" + countryNo + ", countryName=" + countryName + ", countryCapital="
				+ countryCapital + ", countryPopulation=" + countryPopulation + "]";
	}
	
	public CountryDto() {
		super();
	}
}

package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDto {
	private Long year;
	
	private Float totalCredits;
	
	private Float totalProvisionated;
	
	private Float totalPaid;
	
	public ReportDto() {
		
	}
	
	public ReportDto(Float totalCredits, Float totalPaid, Float totalProvisionated) {
		this.totalCredits = totalCredits;
		this.totalPaid = totalPaid;
		this.totalProvisionated = totalProvisionated;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Float getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Float totalCredits) {
		this.totalCredits = totalCredits;
	}

	public Float getTotalProvisionated() {
		return totalProvisionated;
	}

	public void setTotalProvisionated(Float totalProvisionated) {
		this.totalProvisionated = totalProvisionated;
	}

	public Float getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Float totalPaid) {
		this.totalPaid = totalPaid;
	}
	
}

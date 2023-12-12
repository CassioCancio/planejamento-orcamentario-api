package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceCreateDto {

	private String startDate;

	private String endDate;

	private Long year;

	// Constructors

	public BalanceCreateDto() {
		
	}

	// Getters and Setters
	
	public Instant getStartDate() {
		LocalDate date = LocalDate.parse(startDate);
        return date.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant();
	}

	public Instant getEndDate() {
		LocalDate date = LocalDate.parse(endDate);
		return date.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant();
	}

	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "BalanceCreateDto{" +
				"startDate='" + startDate + '\'' +
				"endDate='" + endDate + '\'' +
				"year='" + year+ '\'' +
				'}';
	}
}

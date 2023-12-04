package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeCreateDto {
	
	private String name;

	private String observation;
	
	private Float value;
	
	private String declarantUser;

	private Long balanceYear;
	
	private Long groupId;
	
	// Constructors
	
	public IncomeCreateDto() {
		
	}
	
	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getDeclarantUser() {
		return declarantUser;
	}

	public void setDeclarantUser(String declarantUser) {
		this.declarantUser = declarantUser;
	}

	public Long getBalanceYear() {
		return balanceYear;
	}

	public void setBalanceYear(Long balanceId) {
		this.balanceYear = balanceId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	
}


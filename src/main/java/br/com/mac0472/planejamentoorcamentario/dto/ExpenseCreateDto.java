package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpenseCreateDto {
	
	private String name;
	
	private String observation;
	
	private Float requestedValue;
	
	private String expectedPaymentDate;
	
	private String requester;
	
	private Long groupId;
	
	private Long categoryId;
	
	private String declarantUser;
	
	private Long balanceId;
	
	// Constructors
	
	public ExpenseCreateDto() {
		
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

	public Float getRequestedValue() {
		return requestedValue;
	}

	public void setRequestedValue(Float requestedValue) {
		this.requestedValue = requestedValue;
	}

	public String getExpectedPaymentDate() {
		return expectedPaymentDate;
	}

	public void setExpectedPaymentDate(String expectedPaymentDate) {
		this.expectedPaymentDate = expectedPaymentDate;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long group) {
		this.groupId = group;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long category) {
		this.categoryId = category;
	}

	public String getDeclarantUser() {
		return declarantUser;
	}

	public void setDeclarantUser(String declarant) {
		this.declarantUser = declarant;
	}
	
	public Long getBalanceId() {
		return balanceId;
	}
	
	public void setBalanceId(Long balance) {
		this.balanceId = balance;
	}
}

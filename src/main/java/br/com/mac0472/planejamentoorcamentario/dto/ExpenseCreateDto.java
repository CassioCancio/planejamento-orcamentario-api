package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	
}

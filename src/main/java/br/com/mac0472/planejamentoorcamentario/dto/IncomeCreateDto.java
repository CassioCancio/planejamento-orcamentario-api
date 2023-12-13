package br.com.mac0472.planejamentoorcamentario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class IncomeCreateDto {
	
	private String name;

	private String observation;
	
	private Float value;
	
	private String declarantUser;

	private Long balanceYear;
	
	private Long groupId;
}

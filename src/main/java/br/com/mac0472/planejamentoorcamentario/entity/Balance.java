package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;

import br.com.mac0472.planejamentoorcamentario.dto.BalanceCreateDto;
import br.com.mac0472.planejamentoorcamentario.dto.BalanceDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Balance")
@Table(name="balances", schema="planejamento_orcamentario")
@Data
@NoArgsConstructor
public class Balance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant startDate;
	
	private Instant endDate;
	
	private Long year;

	public Balance(BalanceDto data) {
		startDate = data.getStartDate();
		endDate = data.getEndDate();
		year = data.getYear();
	}

	public Balance(BalanceCreateDto balanceCreateDto) {
		this.startDate = balanceCreateDto.getStartDate();
		this.endDate = balanceCreateDto.getEndDate();
		this.year = balanceCreateDto.getYear();
	}
}

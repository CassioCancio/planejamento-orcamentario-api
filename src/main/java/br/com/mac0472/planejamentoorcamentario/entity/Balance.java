package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Balance")
@Table(name="balances", schema="planejamento_orcamentario")
public class Balance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant startDate;
	
	private Instant endDate;
	
	private Long year;

	// Constructors
	public Balance(Long id, Instant startDate, Instant endDate, Long year) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.year = year;
	}
	public Balance() {
		
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getStartDate() {
		return startDate;
	}
	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}
	public Instant getEndDate() {
		return endDate;
	}
	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
}

package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "Income")
@Table(name="incomes", schema="planejamento_orcamentario")
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private Long value;

	private Instant creationDate;

	private Instant incomeDate;

	private String process;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToOne
	@JoinColumn(name = "balance_id")
	private Balance balance;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Unit unit;

	// Constructors
	public Income(Long id, String description, Long value, Instant creationDate, Instant incomeDate, String process, Group groupId, Balance balanceId, Unit unitId) {
		this.id = id;
		this.description = description;
		this.value = value;
		this.creationDate = creationDate;
		this.incomeDate = incomeDate;
		this.process = process;
		this.group = groupId;
		this.balance = balanceId;
		this.unit =  unitId;
	}
	public Income() {
		
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Instant getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
	public Instant getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Instant incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}

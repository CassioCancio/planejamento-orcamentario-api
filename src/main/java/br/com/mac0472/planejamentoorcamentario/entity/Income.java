package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;
import java.time.ZoneId;

import br.com.mac0472.planejamentoorcamentario.dto.IncomeCreateDto;
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
	
	private String name;
	
	private String observation;
	
	private Float value;

	private Instant creationDate;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToOne
	@JoinColumn(name = "balance_id")
	private Balance balance;

	@ManyToOne
	@JoinColumn(name = "declarant_id")
	private User declarant;
	
	// Constructors
	
	public Income() {
		
	}
	
	public Income(IncomeCreateDto incomeDto, Group group, User declarant, Balance balance) {
		this.name = incomeDto.getName();
		this.observation = incomeDto.getObservation();
		this.value = incomeDto.getValue();
		this.balance = balance;
		this.declarant = declarant;
		this.group = group;
		
		this.creationDate = Instant.now().atZone(ZoneId.of("GMT-3")).toInstant();
	}
	
	// Getters and Setters 
	
	public Long getId() {
		return id;
	}

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

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
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

	public User getDeclarant() {
		return declarant;
	}

	public void setDeclarant(User declarant) {
		this.declarant = declarant;
	}
	
	
}

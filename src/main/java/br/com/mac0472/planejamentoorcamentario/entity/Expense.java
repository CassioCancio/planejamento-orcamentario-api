package br.com.mac0472.planejamentoorcamentario.entity;

import java.time.Instant;
import java.time.ZoneId;

import br.com.mac0472.planejamentoorcamentario.dto.ExpenseCreateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name= "Expense")
@Table(name="expenses", schema="planejamento_orcamentario")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String observation;
	
	private Float requestedValue;
	
	private Float paidValue;
	
	private Float provisionedValue;
	
	private Instant creationDate;
	
	private Instant expectedPaymentDate;
	
	private String requester;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="balance_id")
	private Balance balance;
	
	@ManyToOne
	@JoinColumn(name="declarant_id")
	private User declarant;

	// Constructors
	
	public Expense() {

	}

	public Expense(ExpenseCreateDto expenseDto, Group group, Category category, User declarant) {
		this.name = expenseDto.getName();
		this.observation = expenseDto.getObservation();
		this.requestedValue = expenseDto.getRequestedValue();
		this.provisionedValue = null;
		this.paidValue = Float.valueOf(0);
		this.expectedPaymentDate = expenseDto.getExpectedPaymentDate();
		this.requester = expenseDto.getRequester();
		this.group = group;
		this.category = category;
		this.balance = null;
		this.declarant = declarant;

		this.creationDate = Instant.now().atZone(ZoneId.of("GMT-3")).toInstant();
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

	public Float getPaidValue() {
		return paidValue;
	}

	public void setPaidValue(Float paidValue) {
		this.paidValue = paidValue;
	}

	public Float getProvisionedValue() {
		return provisionedValue;
	}

	public void setProvisionedValue(Float provisionedValue) {
		this.provisionedValue = provisionedValue;
	}

	public Instant getExpectedPaymentDate() {
		return expectedPaymentDate;
	}

	public void setExpectedPaymentDate(Instant expectedPaymentDate) {
		this.expectedPaymentDate = expectedPaymentDate;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public User getDeclarant() {
		return declarant;
	}
	
}

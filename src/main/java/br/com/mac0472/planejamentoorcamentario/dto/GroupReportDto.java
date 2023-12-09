package br.com.mac0472.planejamentoorcamentario.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.mac0472.planejamentoorcamentario.entity.Expense;
import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.entity.Income;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupReportDto extends ReportDto {
	private Long id;
	
	private Long number;
	
	private String name;
	
	private List<Income> incomes;
	
	private List<Expense> expenses;
	
	public GroupReportDto() {
		
	}
	
	public GroupReportDto(ReportDto totals, List<Income> incomes, List<Expense> expenses, Group group) {
		super(totals.getTotalCredits(), totals.getTotalPaid(), totals.getTotalProvisionated());
		this.id = group.getId();
		this.name = group.getName();
		this.number = group.getNumber();
		this.incomes = incomes;
		this.expenses = expenses;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
}

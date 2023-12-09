package br.com.mac0472.planejamentoorcamentario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mac0472.planejamentoorcamentario.dto.GroupReportDto;
import br.com.mac0472.planejamentoorcamentario.dto.ReportDto;
import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.entity.Expense;
import br.com.mac0472.planejamentoorcamentario.entity.Group;
import br.com.mac0472.planejamentoorcamentario.entity.Income;
import br.com.mac0472.planejamentoorcamentario.repository.BalanceRepository;

@Service
public class BalanceService {
	@Autowired
	BalanceRepository balanceRepository;
	
	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	IncomeService incomeService;
	
	@Autowired
	GroupService groupService;
	
	public Balance getBalanceById(Long id) throws RuntimeException {
		Optional<Balance> balanceById = balanceRepository.findById(id);
		return balanceById.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
	}
	
	public Balance getBalanceByYear(Long year) throws RuntimeException {
		Optional<Balance> balanceByYear = balanceRepository.findByYear(year);
		return balanceByYear.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
	}
	
	public List<Balance> getBalances(){
		return balanceRepository.findAll();
	}
	
	public ReportDto getBalanceReport(Long year, Long groupId) {
		List<Expense> expenses = expenseService.getAllByBalanceAndFilter(year, groupId, null, null);
		List<Income> incomes = incomeService.getAllByBalanceAndFilter(year, groupId, null);
		
		ReportDto report = calculateTotals(incomes, expenses);
		report.setYear(year);
		
		return report;
	}
	
	public List<GroupReportDto> getBalanceReportByGroup(Long year) {
		List<Group> groups = groupService.getAllGroups();
		
		List<GroupReportDto> groupsBalanceReport = new ArrayList<>();
		
		for(Group group : groups) {
			List<Expense> expenses = expenseService.getAllByBalanceAndFilter(year, group.getId(), null, null);
			List<Income> incomes = incomeService.getAllByBalanceAndFilter(year, group.getId(), null);
			
			ReportDto totals = calculateTotals(incomes, expenses);
			
			GroupReportDto groupReport = new GroupReportDto(totals, incomes, expenses, group);
			
			groupsBalanceReport.add(groupReport);
		}
		
		return groupsBalanceReport;
	}
	
	private ReportDto calculateTotals(List<Income> incomes, List<Expense> expenses) {
		Float totalProvisionated = Float.valueOf(0);
		Float totalPaid = Float.valueOf(0);
		for(Expense expense : expenses) {
			totalProvisionated += expense.getProvisionedValue();
			totalPaid += expense.getPaidValue();
		}
		
		Float totalCredits = Float.valueOf(0);
		for(Income income : incomes) {
			totalCredits += income.getValue();
		}
		
		return new ReportDto(totalCredits, totalPaid, totalProvisionated);
	}
}

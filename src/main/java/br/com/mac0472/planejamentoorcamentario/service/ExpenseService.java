package br.com.mac0472.planejamentoorcamentario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mac0472.planejamentoorcamentario.dto.ExpenseCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.repository.*;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private BalanceService balanceService;
	
	public Expense getById(Long id) throws RuntimeException {
		Optional<Expense> expenseById = expenseRepository.findById(id);
		
		return expenseById.orElseThrow(() -> new RuntimeException("Despesa Inexistente"));
	}
	
	public List<Expense> getAllByBalanceAndFilter(Long year, Long groupId, Long categoryId, String filter) throws RuntimeException {
		Balance balance = balanceService.getBalanceByYear(year);
		
		return expenseRepository.findByBalanceAndFilter(balance, groupId, categoryId, filter != null ? filter : "");
	}
	
	@Transactional
	public Expense create(ExpenseCreateDto expenseDto) throws RuntimeException {
		Group group = groupService.getGroupById(expenseDto.getGroupId());
		
		Category category = categoryService.getCategoryById(expenseDto.getCategoryId());
		
		User declarant = userService.getDeclarantByNusp(expenseDto.getDeclarantUser());
		
		Balance balance = balanceService.getBalanceByYear(expenseDto.getBalanceYear());
		
		Expense expense = new Expense(expenseDto, group, category, declarant, balance);
		
		return expenseRepository.save(expense);
	}
	
	@Transactional
	public Expense update(Expense expense) throws RuntimeException {
		return expenseRepository.save(expense);
	}
	
	@Transactional
	public void delete(Long expenseId) {
		expenseRepository.deleteById(expenseId);
	}
}

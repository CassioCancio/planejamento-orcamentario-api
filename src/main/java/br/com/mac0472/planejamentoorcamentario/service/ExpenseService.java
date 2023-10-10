package br.com.mac0472.planejamentoorcamentario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mac0472.planejamentoorcamentario.dto.ExpenseCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.*;
import br.com.mac0472.planejamentoorcamentario.repository.*;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private BalanceRepository balanceRepository;
	
	public List<Expense> getAll() {
		return expenseRepository.findAll();
	}
	
	public Expense create(ExpenseCreateDto expenseDto) throws RuntimeException {
		Optional<Group> groupById = groupRepository.findById(expenseDto.getGroupId());
		
		Group group = groupById.orElseThrow(() -> new RuntimeException("Grupo inexistente"));
		
		Optional<Category> categoryById = categoryRepository.findById(expenseDto.getCategoryId());
		
		Category category = categoryById.orElseThrow(() -> new RuntimeException("Categoria inexistente"));
		
		Optional<User> declarantByName = userService.getDeclarantByNusp(expenseDto.getDeclarantUser());
		
		User declarant = declarantByName.orElseThrow(() -> new RuntimeException("User do declarante inexistente"));
		
		Optional<Balance> balanceById = balanceRepository.findById(expenseDto.getBalanceId());
		
		Balance balance = balanceById.orElseThrow(() -> new RuntimeException("Balanço inexistente"));
		
		Expense expense = new Expense(expenseDto, group, category, declarant, balance);
		
		return expenseRepository.save(expense);
	}
}

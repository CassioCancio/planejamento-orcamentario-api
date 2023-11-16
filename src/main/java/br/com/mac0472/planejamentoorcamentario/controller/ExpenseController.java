package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mac0472.planejamentoorcamentario.dto.ExpenseCreateDto;
import br.com.mac0472.planejamentoorcamentario.entity.Expense;
import br.com.mac0472.planejamentoorcamentario.service.ExpenseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/byBalance/{year}")
	public List<Expense> getAllExpensesByBalnce(@PathVariable Long year){
		return expenseService.getAllByBalance(year);
	}
	
	@GetMapping("/{expenseId}")
	public Expense getExpenseById(@PathVariable Long expenseId) {
		return expenseService.getById(expenseId);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Expense createExpense(@RequestBody ExpenseCreateDto expense) {
		return expenseService.create(expense);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public Expense updateExpense(@RequestBody Expense expense) {
		return expenseService.update(expense);
	}
}

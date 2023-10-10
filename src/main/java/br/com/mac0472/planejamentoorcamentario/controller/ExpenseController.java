package br.com.mac0472.planejamentoorcamentario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/getAll")
	public List<Expense> getAllExpenses(){
		return expenseService.getAll();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Expense createExpense(@RequestBody ExpenseCreateDto expense) {
		return expenseService.create(expense);
	}
}
